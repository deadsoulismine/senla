import java.util.Optional;

public class Room {
    private Optional<Boolean> status;
    private Optional<Boolean> free;
    private Optional<Integer> price;
    private Optional<Integer> number;

    public Room() {

    }

    public Room(int number, int price, boolean free, boolean status) {
        this.number = Optional.of(number);
        this.price = Optional.of(price);
        this.free = Optional.of(free);
        this.status = Optional.of(status);
    }

    public Optional<Boolean> getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = Optional.ofNullable(status);
    }

    public Optional<Integer> getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = Optional.ofNullable(price);
    }

    public Optional<Boolean> getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = Optional.ofNullable(free);
    }

    public Optional<Integer> getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = Optional.ofNullable(number);
    }

    public String free() {
        if (getFree().get()) {
            return "свободно";
        } else {
            return "занято";
        }
    }

    public String status() {
        if (getStatus().get()) {
            return "обслуживаемый";
        } else {
            return "ремонтируемый";
        }
    }

}
