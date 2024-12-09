
class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (Available: " + quantity + ")";
    }
}

class FarmerPlatform {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(String name, double price, int quantity) {
        products.add(new Product(name, price, quantity));
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    public void purchaseProduct(int index, int quantity) {
        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid product selection.");
            return;
        }

        Product product = products.get(index);
        if (product.quantity < quantity) {
            System.out.println("Insufficient stock available.");
        } else {
            product.quantity -= quantity;
            System.out.println("Purchased " + quantity + " " + product.name + "(s) for $" + (product.price * quantity));
        }
    }
}

public class LocalFarmerPlatform {
    public static void main(String[] args) {
        FarmerPlatform platform = new FarmerPlatform();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLocal Farmer Platform:");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Purchase Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

}
