public class LineStep implements ILineStep {
    private ProductPart body = buildProductPart("body");
    private ProductPart motherboard = buildProductPart("motherboard");
    private ProductPart monitor = buildProductPart("monitor");

    @Override
    public ProductPart buildProductPart(String part) {
        if (part == "body") {
            ProductPart body = new ProductPart("Body", "contains all parts of computer");
            System.out.println("body created");
            return body;
        }
        else if (part == "motherboard") {
            ProductPart motherboard = new ProductPart("Motherboard", "realised computer architecture");
            System.out.println("motherboard created");
            return motherboard;
        }
        else if (part == "monitor") {
            ProductPart monitor = new ProductPart("Monitor", "means for displaying information");
            System.out.println("monitor created");
            return monitor;
        }
        else {
            System.out.println("I can't to do this part");
            return null;
        }
    }

    public ProductPart getBody() {
        return body;
    }

    public ProductPart getMotherboard() {
        return motherboard;
    }

    public ProductPart getMonitor() {
        return monitor;
    }

}
