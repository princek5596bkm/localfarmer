import java.util.*;

// Base User class
class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// Farmer class
class Farmer extends User {
    private List<Product> products;

    Farmer(String username, String password) {
        super(username, password);
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity) {
        products.add(new Product(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    public void updateProduct(int index, String name, double price, int quantity) {
        if (index >= 0 && index < products.size()) {
            Product product = products.get(index);
            product.name = name;
            product.price = price;
            product.quantity = quantity;
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}

// Buyer class
class Buyer extends User {
    Buyer(String username, String password) {
        super(username, password);
    }

    public void purchaseProduct(Product product, int quantity) {
        if (product.quantity >= quantity) {
            product.quantity -= quantity;
            System.out.println("Purchased " + quantity + " " + product.name + "(s) for $" + (product.price * quantity));
        } else {
            System.out.println("Insufficient stock available.");
        }
    }
}

// Admin class
class Admin extends User {
    Admin(String username, String password) {
        super(username, password);
    }

    public void viewAllUsers(Map<String, User> users) {
        System.out.println("Registered Users:");
        for (String username : users.keySet()) {
            System.out.println("- " + username + " (" + users.get(username).getClass().getSimpleName() + ")");
        }
    }
}

// Product class
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

// Platform class to manage users and roles
class LocalFarmerPlatform {
    private Map<String, User> users;
    private Scanner scanner;
    private User loggedInUser;

    LocalFarmerPlatform() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);

        // Default admin user
        users.put("admin", new Admin("admin", "admin123"));
    }

    public void register(String role) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        switch (role.toLowerCase()) {
            case "farmer":
                users.put(username, new Farmer(username, password));
                break;
            case "buyer":
                users.put(username, new Buyer(username, password));
                break;
            default:
                System.out.println("Invalid role.");
        }
        System.out.println("Registration successful!");
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully.");
    }

    public void run() {
        while (true) {
            if (loggedInUser == null) {
                System.out.println("\n1. Register as Farmer");
                System.out.println("2. Register as Buyer");
                System.out.println("3. Login");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        register("farmer");
                        break;
                    case 2:
                        register("buyer");
                        break;
                    case 3:
                        login();
                        break;
                    case 4:
                        System.out.println("Exiting platform. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } else {
                if (loggedInUser instanceof Farmer) {
                    handleFarmerActions((Farmer) loggedInUser);
                } else if (loggedInUser instanceof Buyer) {
                    handleBuyerActions((Buyer) loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                    handleAdminActions((Admin) loggedInUser);
                }
            }
        }
    }

    private void handleFarmerActions(Farmer farmer) {
        System.out.println("\nFarmer Dashboard:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. View Products");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                farmer.addProduct(name, price, quantity);
                break;
            case 2:
                System.out.print("Enter product index to update: ");
                int indexToUpdate = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.print("Enter new product name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                farmer.updateProduct(indexToUpdate, newName, newPrice, newQuantity);
                break;
            case 3:
                System.out.print("Enter product index to remove: ");
                int indexToRemove = scanner.nextInt() - 1;
                farmer.removeProduct(indexToRemove);
                break;
            case 4:
                List<Product> products = farmer.getProducts();
                if (products.isEmpty()) {
                    System.out.println("No products available.");
                } else {
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                }
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void handleBuyerActions(Buyer buyer) {
        System.out.println("\nBuyer Dashboard:");
        System.out.println("1. View Products");
        System.out.println("2. Purchase Product");
        System.out.println("3. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Product> allProducts = getAllProducts();

        switch (choice) {
            case 1:
                if (allProducts.isEmpty()) {
                    System.out.println("No products available.");
                } else {
                    for (int i = 0; i < allProducts.size(); i++) {
                        System.out.println((i + 1) + ". " + allProducts.get(i));
                    }
                }
                break;
            case 2:
                System.out.print("Enter product index to purchase: ");
                int productIndex = scanner.nextInt() - 1;
                System.out.print("Enter quantity to purchase: ");
                int quantity = scanner.nextInt();

                if (productIndex >= 0 && productIndex < allProducts.size()) {
                    Product product = allProducts.get(productIndex);
                    buyer.purchaseProduct(product, quantity);
                } else {
                    System.out.println("Invalid product selection.");
                }
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void handleAdminActions(Admin admin) {
        System.out.println("\nAdmin Dashboard:");
        System.out.println("1. View All Users");
        System.out.println("2. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                admin.viewAllUsers(users);
                break;
            case 2:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (User user : users.values()) {
            if (user instanceof Farmer) {
                allProducts.addAll(((Farmer) user).getProducts());
            }
        }
        return allProducts;
    }

    public static void main(String[] args) {
        LocalFarmerPlatform platform = new LocalFarmerPlatform();
        platform.run();
    }
}
