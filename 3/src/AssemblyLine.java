public class AssemblyLine implements IAssemblyLine{
    @Override
    public Product assembleProduct(Product product, LineStep lineStep) {

        product.InstallFirstPart(lineStep.body);
        product.InstallSecondPart(lineStep.motherboard);
        product.InstallThirdPart(lineStep.monitor);

        System.out.println("Build of Notebook is complete");
        return product;
    }

}
