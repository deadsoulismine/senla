public class AssemblyLine implements IAssemblyLine {

    @Override
    public Product assembleProduct(Product product) {
        LineStep lineStep = new LineStep();

        System.out.println("Parts created");
        System.out.println("Parts transferred to the Assembly");
        product.InstallFirstPart(lineStep.getBody());
        product.InstallSecondPart(lineStep.getMotherboard());
        product.InstallThirdPart(lineStep.getMonitor());
        System.out.println("Build of Notebook is completed");
        return product;
    }

}
