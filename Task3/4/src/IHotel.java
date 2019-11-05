public interface IHotel {
    void addRoom(Room room);
    void addService(Service service);
    void roomSettle();
    void roomEvict(Room room);
}
