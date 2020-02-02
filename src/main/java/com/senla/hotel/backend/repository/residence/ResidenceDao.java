package com.senla.hotel.backend.repository.residence;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.backend.service.IService;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.database.hibernate.ISession;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.util.Objects;

@Component
public class ResidenceDao implements IResidence {
    @Autowired(className = "ServiceImpl")
    private IService service;
    @Autowired(className = "Data")
    private IData data;
    @Autowired(className = "Session")
    private ISession session;

    //Заселение
    @Override
    public void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        Guest settleGuest = service.getGuestDao().checkGuest(idGuest);
        Room settleRoom = service.getRoomDao().checkRoom(roomNumber);
        if (settleGuest.getRoomNumber() == null) {
            if (settleRoom.getGuests().size() == 0) {

                settleRoom.addGuest(settleGuest);

                session.updateObject(settleGuest);

                //Проверка на переполнение количества записей в истории
//                if (settleRoom.getHistory().size() == parseInt(data.getProp().getProperty("history_size", "1"))) {
//                    settleRoom.getHistory().remove(0);
//                }
//                //Добавление постояльца в историю заселения номера
//                settleRoom.getHistory().add(service.getGuestDao().findAllGuest().stream().filter(
//                        g -> g.getId() == idGuest).findFirst().orElse(null));

                System.out.println("Guest " + settleGuest.getName() + " settled in room: " + settleRoom.getNumber());
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
        Guest evictGuest = service.getGuestDao().checkGuest(idGuest);
        if (evictGuest.getRoomNumber() != null) {
            System.out.println("Guest " + evictGuest.getName() + " evicted from room: " + evictGuest.getRoomNumber());
            //Выселение
            Room evictRoom = service.getRoomDao().findAllRoom().stream().filter(
                    room -> room.getNumber() == evictGuest.getRoomNumber()).findFirst().orElse(null);

            Objects.requireNonNull(evictRoom).removeGuest(evictGuest);

            session.updateObject(evictGuest);

        } else {
            System.out.println("This guest don't settle!");
        }
    }

    @Override
    public void addServices(int idGuest, int idService) {
        Service tempService = service.getServiceDao().findAllService().stream().filter(
                s -> s.getId() == idService).findFirst().orElse(null);
        Guest tempGuest = service.getGuestDao().findAllGuest().stream().filter(
                g -> g.getId() == idGuest).findFirst().orElse(null);
        tempGuest.addService(tempService);

        session.updateObject(tempService);
    }

    @Override
    public void deleteServices(int idGuest, int idService) {
        Service tempService = service.getServiceDao().findAllService().stream().filter(
                s -> s.getId() == idService).findFirst().orElse(null);
        Guest tempGuest = service.getGuestDao().findAllGuest().stream().filter(
                g -> g.getId() == idGuest).findFirst().orElse(null);
        tempGuest.removeService(tempService);

        session.updateObject(tempService);
    }

}
