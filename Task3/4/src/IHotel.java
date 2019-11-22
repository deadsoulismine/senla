public interface IHotel {
    void addRoom(Room room);
    void addService(Service service);
    void addGuest(Guest guest);
    void roomSettle(Guest guest);
    void roomEvict(Guest guest);
}
