public class Main {
    public static void main(String[] args) {
        System.out.println("Assembly is started");

        Product product = new Product();
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.assembleProduct(product);
    }
}
