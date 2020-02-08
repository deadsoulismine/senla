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

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
                if (settleRoom.getHistory().size() == Integer.parseInt(data.getProp().getProperty("history_size", "1"))) {
                    settleRoom.removeRecord();
                }
                //Добавление постояльца в историю заселения номера
                settleRoom.addRecord(service.getGuestDao().findAllGuest().stream().filter(
                        g -> g.getId() == idGuest).findFirst().orElse(null));

                session.updateObject(settleRoom);

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
    public void addServices(int idGuest, int idService) throws ObjectNotExistException {
        Guest tempGuest = service.getGuestDao().checkGuest(idGuest);
        Service tempService = service.getServiceDao().checkService(idService);
        if (tempGuest.getServices().size() == service.getServiceDao().findAllService().size()) {
            System.out.println("This guest has all services!");



        } else if (tempGuest.getServices().stream().noneMatch(s -> s.getId() == idService)) {
            tempGuest.addService(tempService);
            session.updateObject(tempGuest);
        } else {
            System.out.println("This guest has this service!");
        }
    }

    @Override
    public void deleteServices(int idGuest, int idService) throws ObjectNotExistException {
        Service tempService = service.getServiceDao().checkService(idService);
        Guest tempGuest = service.getGuestDao().checkGuest(idGuest);
        if (tempGuest.getServices().size() == 0) {
            System.out.println("This guest hasn't services!");
        } else if (tempGuest.getServices().stream().anyMatch(s -> s.getId() == idService)) {
            tempGuest.removeService(tempService);
            session.updateObject(tempGuest);
        } else {
            System.out.println("This guest hasn't this service!");
        }
    }

    @Override
    public void printListUnusedServices(int idGuest) throws ObjectNotExistException {
        Guest tempGuest = service.getGuestDao().checkGuest(idGuest);

        Set<Integer> id = tempGuest.getServices().stream()
                .map(Service::getId)
                .collect(Collectors.toSet());

        List<Service> listOfDifference = service.getServiceDao().findAllService().stream()
                .filter(s -> !id.contains(s.getId()))
                .collect(Collectors.toList());

        listOfDifference.stream().peek(s -> System.out.println("ID: " + s.getId() + " | Title: " + s.getTitle() +
                " | Price: " + s.getPrice())).collect(Collectors.toList());
    }

    @Override
    public void printListUsedServices(int idGuest) throws ObjectNotExistException {
        Guest tempGuest = service.getGuestDao().checkGuest(idGuest);

        tempGuest.getServices().stream().peek(s -> System.out.println("ID: " + s.getId() + " | Title: " + s.getTitle() +
                " | Price: " + s.getPrice())).collect(Collectors.toList());
    }

}
