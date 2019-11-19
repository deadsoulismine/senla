import java.io.*;
import java.util.ArrayList;

public class File {

    /*AT
        В данном случае рекомендую добавить проверку файла на существование,
        дабы можно было добавлять данные. Проверка производится методом exists()
    */

    public void fileSave(Hotel hotel) {
        try (FileWriter fileWriter = new FileWriter("roomSave.txt")) {
            for (Room room : hotel.roomList()) {
                fileWriter.write(Integer.toString(room.getNumber().get()) + " ");
                fileWriter.write(Integer.toString(room.getPrice().get()) + " ");
                fileWriter.write(room.getFree().get() + " ");
                fileWriter.write(room.getStatus().get() + " ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead(ArrayList<Room> roomList) throws IOException {
        /*AT
        Здесь также желательно использовать try with resources,
        и, наверное, желательно перегрузить метод для всех типов считываемых данных.
         */

        BufferedReader bufferedReader = new BufferedReader(new FileReader("roomRead.txt"));
        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] room = currentLine.split(" ");

            int number = Integer.parseInt(room[0]);
            int price = Integer.parseInt(room[1]);
            boolean free = Boolean.parseBoolean(room[2]);
            boolean status = Boolean.parseBoolean(room[3]);

            Room roomObject = new Room(number, price, free, status);
            roomList.add(roomObject);
        }
        bufferedReader.close();
    }

}
