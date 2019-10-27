public class LineStep implements ILineStep {

    ProductPart body = buildProductPart("body");
    ProductPart motherboard = buildProductPart("motherboard");
    ProductPart monitor = buildProductPart("monitor");

    @Override
    public ProductPart buildProductPart(String part) {
        if (part == "body") {
            ProductPart productPart = new ProductPart("Body", "contains all parts of computer");
            System.out.println("body create");
            return productPart;
        }
        else if (part == "motherboard") {
            ProductPart productPart = new ProductPart("Motherboard", "realised computer architecture");
            System.out.println("motherboard create");
            return productPart;
        }
        else if (part == "monitor") {
            ProductPart productPart = new ProductPart("Monitor", "means for displaying information");
            System.out.println("monitor create");
            return productPart;
        }
        else {
            System.out.println("I can't to do this part");
            return null;
        }
    }

}
