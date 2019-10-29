import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers = new ArrayList<>();

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }


    public void getSum () {
        int sum = 0;
        System.out.print("Bouquet price: ");
        for (Flower n : getFlowers()) {
            sum += n.getPrice();
        }
        System.out.println(sum);
    }

}
