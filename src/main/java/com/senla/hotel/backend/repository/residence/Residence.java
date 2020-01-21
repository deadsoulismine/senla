package com.senla.hotel.backend.repository.residence;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.IData;

import static java.lang.Integer.parseInt;

@Component
public class Residence implements IResidence {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "Data")
    private IData data;

    //Заселение
    @Override
    public void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        Guest settleGuest = service.getGuestGeneral().checkGuest(idGuest);
        Room settleRoom = service.getRoomGeneral().checkRoom(roomNumber);
        if (settleGuest.getRoomNumber() == null) {
            if (settleRoom.getIdGuest() == null) {
                settleGuest.setRoomId(settleRoom.getNumber());
                settleRoom.setIdGuest(settleGuest.getId());
                System.out.println("Guest " + settleGuest.getName() + " settled in room: " + settleRoom.getNumber());
                //Проверка на переполнение количества записей в истории
                if (settleRoom.getHistory().size() == parseInt(data.getProp().getProperty("history_size", "1"))) {
                    settleRoom.getHistory().remove(0);
                }
                //Добавление постояльца в историю заселения номера
                settleRoom.getHistory().add(service.getGuestGeneral().getGuests().stream().filter(
                        g -> g.getId() == idGuest).findFirst().orElse(null));
            } else {
                System.out.println("This room is busy!");
            }
        } else {
            System.out.println("This guest had settled!");
        }
    }

    //Выселение
    @Override
    public void evict(int idGuest) throws ObjectNotExistException {
        Guest evictGuest = service.getGuestGeneral().checkGuest(idGuest);
        if (evictGuest.getRoomNumber() != null) {
            System.out.println("Guest " + evictGuest.getName() + " evicted from room: " + evictGuest.getRoomNumber());
            //Выселение
            Guest guest = service.getGuestGeneral().getGuests().stream().filter(g -> g.getId() == idGuest).
                    findFirst().orElse(null);
            service.getRoomGeneral().getRooms().stream().filter(g -> g.getNumber() == guest.getRoomNumber()).
                    findFirst().orElse(null).setIdGuest(null);
            guest.setRoomId(null);
        } else {
            System.out.println("This guest don't settle!");
        }
    }

}
