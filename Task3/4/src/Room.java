public class Room {
    private Boolean status;
    private Boolean free;
    private int price;
    private int number;


    //Конструктор для файла
    public Room(String line) {
        String[] room = line.split(" ");
        this.status = Boolean.parseBoolean(room[0]);
        this.price = Integer.parseInt(room[1]);
        this.free = Boolean.parseBoolean(room[2]);
        this.number = Integer.parseInt(room[3]);
    }


    public Room(Boolean status, int price, Boolean free, int number) {
        this.status = status;
        this.price = price;
        this.free = free;
        this.number = number;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public void setFree(Boolean free) {
        this.free = free;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String Status() {
        if (getStatus()) {
            return "обслуживаемый";
        }
        else {
            return "ремонтируемый";
        }

    }

}
