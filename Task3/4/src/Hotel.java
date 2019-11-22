import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Hotel implements IHotel {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
    }

    //Добавляем новый номер в список
    @Override
    public void addRoom(Room room) {
        Optional.ofNullable(room).ifPresent(rooms::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addService(Service service) {
        Optional.ofNullable(service).ifPresent(services::add);
    }

    //Добавляем новую услугу в список
    @Override
    public void addGuest(Guest guest) {
        Optional.ofNullable(guest).ifPresent(guests::add);
    }

    public ArrayList<Room> getRooms() {
            return rooms;
    }

    public ArrayList<Room> roomList() {
        return getRooms();
    }

    public ArrayList<Guest> getGuests() { return guests; }

    public ArrayList<Guest> guestList() {return getGuests(); }

    //Поиск свободного номера
    private Room getFreeRoom() {
        for (Room n : roomList()) {
            if (n.getStatus() == true && n.getFree() == true) {
                n.setFree(false);
                return n;
            }
            else {
                System.out.println("Нет свободных номеров!");
            }
        }
        return null;
    }

    //Заселение
    public void roomSettle(Guest guest) {
        Optional<Room> tempRoom = Optional.ofNullable(getFreeRoom());
        guestList().add(guest);
        if (tempRoom.isPresent()) {
            guest.setRoomId(tempRoom.get().getNumber());
            System.out.println("Постоялец " + guest.getName() + " заселен в номер: " + tempRoom.get().getNumber());
        }
    }

    //Выселение
    public void roomEvict(Guest guest) {
        for (Room n : roomList()) {
            if (n.getNumber() == guest.getRoomId()) {
                n.setFree(true);
                guestList().remove(guest);
                System.out.println("Постоялец " + guest.getName() + " выселен из номера: " + n.getNumber());
            }
        }
    }

    public void printRoomList() {
        Arrays.asList(roomList());
        //Вывод существующих комнат на экран
        System.out.println("Список существующих номеров: ");
        for (Room room : roomList()) {
            System.out.println("Номер: " + room.getNumber() + " | Стоимость: " + room.getPrice() +
                    " | " + room.free() + " | " + room.status());
        }
    }

    public String checkPrint (Object object) {
        if (!Optional.ofNullable(object).isPresent()) {
            return "[Не указано]";
        }
        else {
            return object.toString();
        }
    }
}
