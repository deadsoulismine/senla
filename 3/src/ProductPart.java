public class ProductPart implements IProductPart {
    private String nameOfPart;
    private String description;

    public ProductPart(String nameOfPart, String description) {
        this.nameOfPart = nameOfPart;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfPart() {
        return nameOfPart;
    }

    public void setNameOfPart(String nameOfPart) {
        this.nameOfPart = nameOfPart;
    }

    public String Action () {
        return "installed";
    }

}
