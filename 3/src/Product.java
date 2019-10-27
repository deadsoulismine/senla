public class Product implements IProduct {
    @Override
    public void InstallFirstPart(ProductPart body) {
        System.out.println(body.getNameOfPart() + " " + body.Action());
    }

    @Override
    public void InstallSecondPart(ProductPart motherboard) {
        System.out.println(motherboard.getNameOfPart() + " " + motherboard.Action());
    }

    @Override
    public void InstallThirdPart(ProductPart monitor) {
        System.out.println(monitor.getNameOfPart() + " " + monitor.Action());
    }
}
