public class Main {
    public static void main(String[] args) {
        System.out.println("Assembly is started");

        LineStep lineStep = new LineStep();
        System.out.println("Parts created");
        Product product = new Product();
        System.out.println("Parts transferred to the Assembly");
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.assembleProduct(product,lineStep);
    }
}
