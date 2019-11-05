import java.util.Random;

class Number {

    private static int number = getRandom();

    public static int getRandom() {

        int number;
        
        Random random = new Random();
        number = 100 + random.nextInt(900);
        return number;

    }

    public static int sumNumbers() {

        String str = Integer.toString(number);
        int length = str.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum = sum + Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }

    public static int getNumber() {
        return number;
    }

}
