public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Гостиница");
        Room room1 = new Room(true, 1500, true, 101);
        Room room2 = new Room(true, 1500, true, 102);
        Room room3 = new Room(true, 1500, true, 103);
        Service service1 = new Service(1000, "Завтрак в постель");

        //Добавление номера
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

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
