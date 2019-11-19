import java.util.*;
import java.lang.String;

public class MyStream {
    private List<String> prices = new ArrayList<>();
    private List<String> numbers = new ArrayList<>();

    private void addPrices(Hotel hotel) {
        for(Room item : hotel.roomList()) {
            prices.add(String.valueOf(item.getPrice()));
        }
    }

    private void addNumbers(Hotel hotel) {
        for(Room item : hotel.roomList()) {
            numbers.add(String.valueOf(item.getNumber()));
        }
    }

    //distinct
    //Вывод уникальных стоймостей
    public void useDistinct(Hotel hotel) {
        System.out.println("В отеле доступны номера со стоймостью:");
        prices.clear();
        addPrices(hotel);
        prices.stream().distinct().forEach(System.out::println);
    }

    //limit
    //Вывести количество указанных первых комнат в отеле
    public void useLimit(Hotel hotel, int limit) {
        numbers.clear();
        addNumbers(hotel);
        numbers.stream().limit(limit).forEach(System.out::println);
    }

    //noneMatch
    //Искать комнату (в данном случае с ценой), с заданными критериями поиска
    public boolean useNoneMatch (Hotel hotel, String price) {
        prices.clear();
        addPrices(hotel);
        return prices.stream().noneMatch(price::equals);
    }

    //max
    //Найти самую дорогую комнату
    public String useMax(Hotel hotel) {
        prices.clear();
        addPrices(hotel);
        return prices.stream().max(String::compareTo).get();
    }

    //average
    //Средняя стоймость номера
    public double useAverage(Hotel hotel) {
        prices.clear();
        addPrices(hotel);
        return prices.stream().mapToInt(Integer::parseInt).average().getAsDouble();
    }

}
