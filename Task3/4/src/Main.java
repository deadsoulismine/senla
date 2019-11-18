import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Hotel hotel = new Hotel("Гостиница");
        File file = new File();
        MyStream myStream = new MyStream();
        //Считывание данных из файла
        file.fileRead(hotel.roomList());
        //Создание экземпляра класса комната и услуга вручную
        Room room1 = new Room(110, 3000, false, false);
        Optional<Room> optionalRoom1 = Optional.ofNullable(room1);

        Service service1 = new Service(1000, "Завтрак в постель");

        //Добавление номера
        hotel.addRoom(room1);

        //Вывод существующих комнат на экран
        System.out.println("Список существующих номеров: ");
        for (Room room : hotel.roomList()) {
            System.out.println("Номер: " + room.getNumber() + " | Стоимость: " + room.getPrice() + " | " + room.free() + " | " + room.status());
        }

        //Добавление услуги
        hotel.addService(service1);

        //Заселение
        hotel.roomSettle();

        //Выселение
        hotel.roomEvict(room1);

        //Изменение статуса на "Ремонтируемый"
        room1.setStatus(false);
        System.out.println("В данный момент номер " + room1.getNumber() + " имеет статус " + room1.status());

        //Изменение статуса на "Обслуживаемый"
        room1.setStatus(true);
        System.out.println("В данный момент номер " + room1.getNumber() + " имеет статус " + room1.status());

        //Изменение цены номера
        System.out.print("Произошло изменение цены номера " + room1.getNumber() + " с " + room1.getPrice() + " на ");
        room1.setPrice(2000);
        System.out.println(room1.getPrice());

        //Изменение цены услуги
        System.out.print("Произошло изменение цены услуги '" + service1.getName() + "' с " + service1.getPrice() + " на ");
        service1.setPrice(1500);
        System.out.println(service1.getPrice());

        //Вывести первые несколько номеров в отеле [Limit]
        int testLimit = 3;
        System.out.println("Первые " + testLimit + " комнаты имеют номера:");
        myStream.useLimit(hotel, testLimit);

        //Узнать, есть ли номер с указанной стоймостью [NoneMatch]
        String testPrice = "2000";
        if (myStream.useNoneMatch(hotel, testPrice)) {
            System.out.println("Нет ни одной комнаты со стоймостью " + testPrice + "!");
        } else {
            System.out.println("В отеле есть комната со стоймостью " + testPrice + "!");
        }

        //Вывод уникальных стоймостей номеров [Distinct]
        System.out.println("В отеле доступны номера со стоймостью:");
        myStream.useDistinct(hotel);

        //Поиск самой дорогого номера [Max]
        System.out.println("Самый дорогой номер в отеле имеет стоймость: " + myStream.useMax(hotel));

        //Поиск средней стоймости номеров [Average]
        System.out.println("Средняя стоймость всех номеров: " + myStream.useAverage(hotel));

        //Запись данных в файл
        file.fileSave(hotel);
    }

}
