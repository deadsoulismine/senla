public class Record {
    private String fullName;
    private String title;

    public Record(String fullName, String title) {
        this.fullName = fullName;
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
