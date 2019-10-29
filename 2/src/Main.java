public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        //Create flowers
        Flower rose1 = new Flower(100, "rose1");
        Flower rose2 = new Flower(150, "rose2");
        Flower rose3 = new Flower(200, "rose3");
        Flower lily = new Flower(300, "lily");
        Flower tulip = new Flower(200, "tulip");

        //Add flowers to bouquet
        bouquet.addFlower(rose1);
        bouquet.addFlower(rose2);
        bouquet.addFlower(rose3);
        bouquet.addFlower(lily);
        bouquet.addFlower(tulip);

        //flowers list
        System.out.println("Bouquet list: ");
        for (Flower n : bouquet.getFlowers()) {
            System.out.println("Title: " + n.getTitle() + " Price: " + n.getPrice());
        }

        //Sum of bouquet
        bouquet.getSum();

    }

}
