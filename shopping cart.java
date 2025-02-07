import java.util.Scanner;

class Products {
    Scanner sc = new Scanner(System.in);
    int count = 0;
    int totalAmount = 0; // Total amount of all products

    String item[] = new String[100];  // Array to store product names
    int code[] = new int[100];  // Array to store product codes
    int price[] = new int[100]; // Array to store product prices

    void add() {
        System.out.print("\nEnter Product Name: ");
        item[count] = sc.nextLine(); // Store product name
        System.out.print("Enter Product Code: ");
        code[count] = sc.nextInt(); // Store product code
        System.out.print("Enter Product Price: ");
        price[count] = sc.nextInt(); // Store product price
        sc.nextLine(); // Consume newline
        totalAmount += price[count]; // Add price to total amount
        count++;
        System.out.println("\nItem added successfully.");
    }

    void change() {
        System.out.print("\nEnter Product Code to Change: ");
        int prodCode = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < count; i++) {
            if (code[i] == prodCode) {
                System.out.print("Enter New Product Name: ");
                item[i] = sc.nextLine();
                System.out.print("Enter New Product Price: ");
                totalAmount -= price[i]; // Remove old price from total
                price[i] = sc.nextInt();
                totalAmount += price[i]; // Add new price to total
                sc.nextLine();
                System.out.println("\nProduct updated successfully.");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    void total() {
        System.out.println("\nTotal Amount of all products: ₹" + totalAmount);
    }

    void qnty() {
        System.out.println("\nTotal Quantity of Items: " + count);
    }

    void list() {
        System.out.println("\nProduct List:");
        if (count == 0) {
            System.out.println("No products added yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Product Name: " + item[i] + " | Code: " + code[i] + " | Price: ₹" + price[i]);
        }
    }

    void cancel() {
        System.out.println("\nAll items removed. Cart is empty!");
        count = 0;
        totalAmount = 0;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int choice;

        System.out.println("\n\t*----------- Welcome To Shopping Cart -----------*\n");
        System.out.println("Hi Dear");
        System.out.print("Enter Your Name: ");
        name = sc.nextLine();

        Products products = new Products(); // Single instance to maintain data

        System.out.println("\nHello " + name + ", Welcome to Shopping Cart!");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1) Add Product");
            System.out.println("2) Change Product Details");
            System.out.println("3) Check Total Amount");
            System.out.println("4) Check Quantity of Items");
            System.out.println("5) View Product List");
            System.out.println("6) Cancel All Items");
            System.out.println("0) Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    products.add();
                    break;
                case 2:
                    products.change();
                    break;
                case 3:
                    products.total();
                    break;
                case 4:
                    products.qnty();
                    break;
                case 5:
                    products.list();
                    break;
                case 6:
                    products.cancel();
                    break;
                case 0:
                    System.out.println("Thank you for using the Shopping Cart. Exiting... Bye " + name);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}
