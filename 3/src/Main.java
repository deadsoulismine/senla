public class Main {
    public static void main(String[] args) {
        LineStep lineStep = new LineStep();
        Product product = new Product();
        AssemblyLine assemblyLine = new AssemblyLine();

        assemblyLine.assembleProduct(product,lineStep);
    }
}
