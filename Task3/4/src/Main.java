import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel("Гостиница");
        File file = new File();
        MyStream myStream = new MyStream();
        //Создание экземпляра класса комната и услуга вручную
        Room room1 = new Room(110, 3000, false, false);
        Service service1 = new Service(1000, "Завтрак в постель");
        Guest guest1 = new Guest("Иванов", 25, 0);
        //Считывание данных из файла
        file.fileRead(hotel.roomList());

        //Добавление номера
        hotel.addRoom(room1);

        //Вывод существующих номеров на экран
        hotel.printRoomList();

        //Добавление услуги
        hotel.addService(service1);

        //Заселение
        hotel.roomSettle(guest1);

        //Выселение
        hotel.roomEvict(guest1);

        //Изменение статуса на "Ремонтируемый"
        room1.setStatus(false);
        System.out.println("В данный момент номер " + room1.getNumber() +
                " имеет статус " + room1.status());

        //Изменение статуса на "Обслуживаемый"
        room1.setStatus(true);
        System.out.println("В данный момент номер " + room1.getNumber() +
                " имеет статус " + room1.status());

        //Изменение цены номера
        System.out.print("Произошло изменение цены номера " + room1.getNumber() +
                " с " + room1.getPrice() + " на ");
        int testPriceOne = 5000;
        room1.setPrice(testPriceOne);
        System.out.println(room1.getPrice());

        //Изменение цены услуги
        System.out.print("Произошло изменение цены услуги '" + service1.getName() + "' с " +
                service1.getPrice() + " на ");
        int testPriceTwo = 1500;
        service1.setPrice(testPriceTwo);
        System.out.println(service1.getPrice());

        //Вывести первые несколько номеров в отеле [Limit]
        int testLimit = 3;
        System.out.println("Первые " + testLimit + " аппарартамента имеют номера:");
        myStream.useLimit(hotel, testLimit);

        //Узнать, есть ли номер с указанной стоймостью [NoneMatch]
        String testPrice = "2000";
        if (myStream.useNoneMatch(hotel, testPrice)) {
            System.out.println("Нет ни одного номера со стоймостью " + testPrice + "!");
        } else {
            System.out.println("В отеле есть номер со стоймостью " + testPrice + "!");
        }

        //Вывод уникальных стоймостей номеров [Distinct]
        myStream.useDistinct(hotel);

        //Поиск самой дорогого номера [Max]
        System.out.println("Самый дорогой номер в отеле имеет стоймость: " + myStream.useMax(hotel));

        //Поиск средней стоймости номеров [Average]
        System.out.println("Средняя стоймость всех номеров: " + myStream.useAverage(hotel));

        int testId = 105;
        if (myStream.removeRoomWithNumber(hotel, testId)) {
            System.out.println("Аппартаменты под номером " + testId + " удалены!");
        } else {
            System.out.println("Нельзя удалить аппартаменты под указанным номером, поскольку их нет!");
        }

        hotel.printRoomList();

        //Запись данных в файл
        file.fileSave(hotel);
    }

}
