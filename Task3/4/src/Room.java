public class Room {
    private boolean status;
    private boolean free;
    private int price;
    private int number;

    private int guestId;

    public Room(int number, int price, boolean free, boolean status) {
        this.number = number;
        this.price = price;
        this.free = free;
        this.status = status;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public boolean getStatus() {
            return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String free() {
        if (getFree() && getStatus()) {
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
