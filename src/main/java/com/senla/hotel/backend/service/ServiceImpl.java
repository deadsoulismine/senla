package com.senla.hotel.backend.service;

import com.senla.hotel.backend.repository.guest.IGuestDao;
import com.senla.hotel.backend.repository.guest.IGuestSerialisation;
import com.senla.hotel.backend.repository.residence.IResidence;
import com.senla.hotel.backend.repository.room.IRoomDao;
import com.senla.hotel.backend.repository.room.IRoomSerialisation;
import com.senla.hotel.backend.repository.service.IServiceDao;
import com.senla.hotel.backend.repository.service.IServiceSerialisation;
import com.senla.hotel.ui.exception.ListIsEmptyException;
import com.senla.hotel.ui.exception.ObjectNotExistException;
import com.senla.hotel.ui.exception.SameObjectsException;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.sql.SQLException;

@Component
public class ServiceImpl implements IService {
    @Autowired(className = "GuestDao")
    private IGuestDao guestDao;
    @Autowired(className = "GuestSerialisation")
    private IGuestSerialisation guestSerialisation;
    @Autowired(className = "RoomDao")
    private IRoomDao roomDao;
    @Autowired(className = "RoomSerialisation")
    private IRoomSerialisation roomSerialisation;
    @Autowired(className = "ServiceDao")
    private IServiceDao serviceDao;
    @Autowired(className = "ServiceSerialisation")
    private IServiceSerialisation serviceSerialisation;
    @Autowired(className = "ResidenceDao")
    private IResidence residenceDao;

    @Override
    public void addRoom(int number, int price) throws SameObjectsException {
        getRoomDao().addRoom(number, price);
    }

    @Override
    public void addGuest(String name, int age) throws ReflectiveOperationException, SQLException {
        getGuestDao().addGuest(name, age);
    }

    @Override
    public void addService(int price, String title) throws SameObjectsException {
        getServiceDao().addService(price, title);
    }

    @Override
    public void deleteRoom(int idRoom) throws ObjectNotExistException {
        getRoomDao().deleteRoom(idRoom);
    }

    @Override
    public void deleteGuest(int idGuest) throws ObjectNotExistException {
        getGuestDao().deleteGuest(idGuest);
    }

    @Override
    public void deleteService(int idService) throws ObjectNotExistException {
        getServiceDao().deleteService(idService);
    }

    @Override
    public void settle(int idGuest, int roomNumber) throws ObjectNotExistException {
        getResidenceDao().settle(idGuest, roomNumber);
    }

    @Override
    public void evict(int idGuest) throws ObjectNotExistException {
        getResidenceDao().evict(idGuest);
    }

    @Override
    public void changeRoomStatus(int idRoom) throws ObjectNotExistException {
        getRoomDao().changeRoomStatus(idRoom);
    }

    @Override
    public void changeRoomPrice(int idRoom, int price) throws ObjectNotExistException {
        getRoomDao().changeRoomPrice(idRoom, price);
    }

    @Override
    public void changeServicePrice(int idRoom, int price) throws ObjectNotExistException {
        getServiceDao().changeServicePrice(idRoom, price);
    }

    @Override
    public void printRoomList() throws ListIsEmptyException {
        getRoomDao().printRoomList();
    }

    @Override
    public void printGuestList() throws ListIsEmptyException {
        getGuestDao().printGuestList();
    }

    @Override
    public void printServiceList() throws ListIsEmptyException {
        getServiceDao().printServiceList();
    }

    @Override
    public void printFreeRoomList() throws ListIsEmptyException {
        getRoomDao().printFreeRoomList();
    }

    @Override
    public void printWaitingGuests() throws ListIsEmptyException {
        getGuestDao().printWaitingGuests();
    }

    @Override
    public void printSettleGuests() throws ListIsEmptyException {
        getGuestDao().printSettleGuests();
    }

    @Override
    public void printListUnusedServices(int idGuest) throws ObjectNotExistException {
        getResidenceDao().printListUnusedServices(idGuest);
    }

    @Override
    public void printListUsedServices(int idGuest) throws ObjectNotExistException {
        getResidenceDao().printListUsedServices(idGuest);
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
    public IGuestDao getGuestDao() {
        return guestDao;
    }

    @Override
    public IGuestSerialisation getGuestSerialisation() {
        return guestSerialisation;
    }

    @Override
    public IRoomDao getRoomDao() {
        return roomDao;
    }

    @Override
    public IRoomSerialisation getRoomSerialisation() {
        return roomSerialisation;
    }

    @Override
    public IServiceDao getServiceDao() {
        return serviceDao;
    }

    @Override
    public IServiceSerialisation getServiceSerialisation() {
        return serviceSerialisation;
    }

    @Override
    public IResidence getResidenceDao() {
        return residenceDao;
    }

    @Override
    public void changeRoomNumber(int idRoom, int number) throws ObjectNotExistException {
        getRoomDao().changeRoomNumber(idRoom, number);
    }

    @Override
    public void changeGuestName(int idGuest, String name) throws ObjectNotExistException {
        getGuestDao().changeGuestName(idGuest, name);
    }

    @Override
    public void changeGuestAge(int idGuest, int age) throws ObjectNotExistException {
        getGuestDao().changeGuestAge(idGuest, age);
    }

    @Override
    public void changeServiceTitle(int idService, String title) throws ObjectNotExistException {
        getServiceDao().changeServiceTitle(idService, title);
    }

    @Override
    public void addServices(int idGuest, int idService) throws ObjectNotExistException {
        getResidenceDao().addServices(idGuest, idService);
    }

    @Override
    public void deleteServices(int idGuest, int idService) throws ObjectNotExistException {
        getResidenceDao().deleteServices(idGuest, idService);
    }
}
