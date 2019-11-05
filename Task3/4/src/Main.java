import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Hotel hotel = new Hotel("Гостиница");

        File file = new File();
        //Считывание данных из файла
        file.fileRead(hotel.roomList());
        Room room1 = new Room(true, 1500, true,105);

        Service service1 = new Service(1000, "Завтрак в постель");

        //Добавление номера

            hotel.addRoom(room1);

        for (Room room : hotel.roomList()) {
            System.out.println(room.status() + " | Стоймость номера: " + room.getPrice() + " | " + room.free() + " | Номер комнаты: " + room.getNumber());
        }

        //Запись данных в файл
        file.fileSave(hotel.roomList(), hotel);


        //Добавление услуги
        hotel.addService(service1);

        //Заселение
        hotel.roomSettle();

        //Выселение
        hotel.roomEvict(room1);

        //Изменение статуса на "Ремонтируемый"
        room1.setStatus(false);
        System.out.println("В данный момент номер " + room1.getNumber() + " имеет статус " + room1.Status());

        //Изменение статуса на "Обслуживаемый"
        room1.setStatus(true);
        System.out.println("В данный момент номер " + room1.getNumber() + " имеет статус " + room1.Status());

        //Изменение цены номера
        System.out.print("Произошло изменение цены номера " + room1.getNumber() + " с " + room1.getPrice() + " на ");
        room1.setPrice(2000);
        System.out.println(room1.getPrice());

        //Изменение цены услуги
        service1.setPrice(1500);

    }

}
