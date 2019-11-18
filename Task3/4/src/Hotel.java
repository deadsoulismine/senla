import java.util.ArrayList;

public class Hotel implements IHotel {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Создаём экземпляр класса комната
    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    //Создаём экземпляр класса услуга
    @Override
    public void addService(Service service) {
        services.add(service);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<Room> roomList() {
        return getRooms();
    }

    //Заселение
    private Room getFreeRoom() {
        for (Room n : roomList()) {
            if (n.getStatus().get() == true && n.getFree().get() == true) {
                n.setFree(false);
                return n;
            }
        }
        return null;
    }

    public void roomSettle() {
        Room tempRoom = getFreeRoom();
        if (tempRoom != null) {
            System.out.println("Вы заселены в комнату: " + tempRoom.getNumber());
        }
        else {
            System.out.println("Нет свободных комнат!");
        }
    }

    //Выселение
    @Override
    public void roomEvict(Room room) {
        room.setFree(true);
        System.out.println("Вы выселены из комнаты: " + room.getNumber());
    }

}
