package com.senla.hotel.backend.service;

import com.senla.hotel.backend.repository.guest.IGuestGeneral;
import com.senla.hotel.backend.repository.guest.IGuestSerialisation;
import com.senla.hotel.backend.repository.residence.IResidence;
import com.senla.hotel.backend.repository.room.IRoomGeneral;
import com.senla.hotel.backend.repository.room.IRoomSerialisation;
import com.senla.hotel.backend.repository.service.IServiceGeneral;
import com.senla.hotel.backend.repository.service.IServiceSerialisation;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;

@Component
public class ServiceImpl implements IService {
    @Autowired(className = "GuestGeneral")
    private IGuestGeneral guestGeneral;
    @Autowired(className = "GuestSerialisation")
    private IGuestSerialisation guestSerialisation;
    @Autowired(className = "RoomGeneral")
    private IRoomGeneral roomGeneral;
    @Autowired(className = "RoomSerialisation")
    private IRoomSerialisation roomSerialisation;
    @Autowired(className = "ServiceGeneral")
    private IServiceGeneral serviceGeneral;
    @Autowired(className = "ServiceSerialisation")
    private IServiceSerialisation serviceSerialisation;
    @Autowired(className = "Residence")
    private IResidence residence;

    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        getRoomGeneral().addRoom(number, price);
    }

    @Override
    public void addGuest(String name, int age) throws ReflectiveOperationException {
        getGuestGeneral().addGuest(name, age);
    }

    @Override
    public void addService(int price, String title) throws SameObjectsException {
        getServiceGeneral().addService(price, title);
    }

    @Override
    public void deleteRoom(int idRoom) throws ObjectNotExistException {
        getRoomGeneral().deleteRoom(idRoom);
    }

    @Override
    public void deleteGuest(int idGuest) throws ObjectNotExistException {
        getGuestGeneral().deleteGuest(idGuest);
    }

    @Override
    public void deleteService(int idService) throws ObjectNotExistException {
        getServiceGeneral().deleteService(idService);
    }

    @Override
    public void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        getResidence().settle(idGuest, roomNumber);
    }

    @Override
    public void evict(int idGuest) throws ObjectNotExistException {
        getResidence().evict(idGuest);
    }

    @Override
    public void changeRoomStatus(int idRoom) throws ObjectNotExistException {
        getRoomGeneral().changeRoomStatus(idRoom);
    }

    @Override
    public void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException {
        getRoomGeneral().changeRoomPrice(idRoom, price);
    }

    @Override
    public void changeServicePrice(int idRoom, int price) throws ObjectNotExistException {
        getServiceGeneral().changeServicePrice(idRoom, price);
    }

    @Override
    public void printRoomList() throws ListIsEmptyException {
        getRoomGeneral().printRoomList();
    }

    @Override
    public void printGuestList() throws ListIsEmptyException {
        getGuestGeneral().printGuestList();
    }

    @Override
    public void printServiceList() throws ListIsEmptyException {
        getServiceGeneral().printServiceList();
    }

    @Override
    public void printFreeRoomList() throws ListIsEmptyException {
        getRoomGeneral().printFreeRoomList();
    }

    @Override
    public void printWaitingGuests() throws ListIsEmptyException {
        getGuestGeneral().printWaitingGuests();
    }

    @Override
    public void printSettleGuests() throws ListIsEmptyException {
        getGuestGeneral().printSettleGuests();
    }

    @Override
    public void fileLoadGuest(String stringScanner) {
        getGuestSerialisation().fileLoadGuest(stringScanner);
    }

    @Override
    public void fileSaveGuest(String stringScanner) {
        getGuestSerialisation().fileSaveGuest(stringScanner);
    }

    @Override
    public void fileLoadRoom(String stringScanner) {
        getRoomSerialisation().fileLoadRoom(stringScanner);
    }

    @Override
    public void fileSaveRoom(String stringScanner) {
        getRoomSerialisation().fileSaveRoom(stringScanner);
    }

    @Override
    public void fileLoadService(String stringScanner) {
        getServiceSerialisation().fileLoadService(stringScanner);
    }

    @Override
    public void fileSaveService(String stringScanner) {
        getServiceSerialisation().fileSaveService(stringScanner);
    }

    @Override
    public void saveGuestId() {
        getGuestSerialisation().saveGuestId();
    }

    @Override
    public void saveServiceId() {
        getServiceSerialisation().saveServiceId();
    }

    @Override
    public IGuestGeneral getGuestGeneral() {
        return guestGeneral;
    }

    @Override
    public IGuestSerialisation getGuestSerialisation() {
        return guestSerialisation;
    }

    @Override
    public IRoomGeneral getRoomGeneral() {
        return roomGeneral;
    }

    @Override
    public IRoomSerialisation getRoomSerialisation() {
        return roomSerialisation;
    }

    @Override
    public IServiceGeneral getServiceGeneral() {
        return serviceGeneral;
    }

    @Override
    public IServiceSerialisation getServiceSerialisation() {
        return serviceSerialisation;
    }

    @Override
    public IResidence getResidence() {
        return residence;
    }
}
