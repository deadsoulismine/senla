public class Reader {

    private String fullName;
    private String adress;

    public Reader(String fullName, String adress) {
        this.fullName = fullName;
        this.adress = adress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
