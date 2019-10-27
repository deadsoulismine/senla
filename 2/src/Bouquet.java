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



}
