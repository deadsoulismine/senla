import java.util.Optional;

public class Room {
    private Optional<Boolean> status;
    private Optional<Boolean> free;
    private Optional<Integer> price;
    private Optional<Integer> number;

    public Room(Integer number, Integer price, Boolean free, Boolean status) {
        this.number = Optional.ofNullable(number);
        this.price = Optional.ofNullable(price);
        this.free = Optional.of(free);
        this.status = Optional.of(status);
    }

    public Boolean getStatus() {
        if (status.isPresent()) {
            return status.get();
        } else {
            return null;
        }
    }

    public void setStatus(Boolean status) {
        this.status = Optional.ofNullable(status);
    }

    public Integer getPrice() {
        if (price.isPresent()) {
            return price.get();
        } else {
            return null;
        }
    }

    public void setPrice(Integer price) {
        this.price = Optional.ofNullable(price);
    }

    public Boolean getFree() {
        if (free.isPresent()) {
            return free.get();
        } else {
            return null;
        }
    }

    public void setFree(Boolean free) {
        this.free = Optional.ofNullable(free);
    }

    public Integer getNumber() {
        if (price.isPresent()) {
            return price.get();
        } else {
            return null;
        }
    }

    public void setNumber(Integer number) {
        this.number = Optional.ofNullable(number);
    }

    public String free() {
        if (getFree()) {
            return "свободно";
        } else {
            return "занято";
        }
    }

    public String status() {
        if (getStatus()) {
            return "обслуживаемый";
        } else {
            return "ремонтируемый";
        }
    }

}
