import java.io.IOException;
import java.util.Random;

public class Test {
    private static final int SIZE = 1500000;
    public static void main(String[] args) throws IOException {

        /*AT
        Чтобы избежать комментариев с кусками кода,
        лучше разделить на две программы.
         */

        Random random = new Random();
        var doubleElements = new MyCollection<>(new Double[SIZE]);
        for (int i = 0; i < SIZE; i++) {
            doubleElements.add(random.nextDouble());
        }

        var stringElements = new MyCollection<>(new String[SIZE]);
        for (int i = 0; i < SIZE; i++) {
            stringElements.add(new String("lorem ipsum" + i));
        }

        System.in.read();
    }
}
