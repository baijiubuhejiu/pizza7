import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class CustomPizza {
    private String toppings;
    private double price;

    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomPizza{toppings='" + toppings + "', price=" + price + "}";
    }
}


class HandleOrders {
    private ArrayList<CustomPizza> customPizzas;

    public HandleOrders() {
        customPizzas = new ArrayList<>();
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pizza Menu:");
        System.out.println("1. Preset Pizza 1");
        System.out.println("2. Preset Pizza 2");
        System.out.println("3. Custom Pizza");
        System.out.println("Enter your pizza choice (1 - 3): ");
        int pizzaChoice = scanner.nextInt();
        scanner.nextLine(); 

        if (pizzaChoice == 3) {
            System.out.println("Available Pizza Toppings:");
            System.out.println("1. Pepperoni");
            System.out.println("2. Mushrooms");
            System.out.println("3. Onions");
            StringBuilder toppingBuilder = new StringBuilder();
            double totalPrice = 0;
            while (true) {
                System.out.println("Select a topping (1 - 3), or 0 to finish choosing toppings: ");
                int toppingChoice = scanner.nextInt();
                scanner.nextLine(); 
                if (toppingChoice == 0) {
                    break;
                }
                if (toppingChoice >= 1 && toppingChoice <= 3) {
                    switch (toppingChoice) {
                        case 1:
                            toppingBuilder.append("Pepperoni, ");
                            totalPrice += 2.0;
                            break;
                        case 2:
                            toppingBuilder.append("Mushrooms, ");
                            totalPrice += 1.5;
                            break;
                        case 3:
                            toppingBuilder.append("Onions, ");
                            totalPrice += 1.0;
                            break;
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            if (toppingBuilder.length() > 0) {
                toppingBuilder.delete(toppingBuilder.length() - 2, toppingBuilder.length());
            }
            CustomPizza customPizza = new CustomPizza(toppingBuilder.toString(), totalPrice);
            customPizzas.add(customPizza);
        }
    }

    public void displayCustomPizzas() {
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    public static void main(String[] args) {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.displayCustomPizzas();
    }
}


class OrderLogs {
    private Deque<String> orderLogs;

    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void showTopLog() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Top log: " + orderLogs.peek());
        } else {
            System.out.println("The stack is empty.");
        }
    }

    private void removeTopLog() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Removed log: " + orderLogs.pop());
        } else {
            System.out.println("The stack is empty.");
        }
    }

    private void clearLogs() {
        orderLogs.clear();
        System.out.println("The stack has been cleared.");
    }

    private void checkIfEmpty() {
        if (orderLogs.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is not empty.");
        }
    }

    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Order Log Operations:");
            System.out.println("1. Show top log");
            System.out.println("2. Remove top log");
            System.out.println("3. Clear logs");
            System.out.println("4. Check if empty");
            System.out.println("5. Exit");
            System.out.println("Enter your choice (1 - 5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    showTopLog();
                    break;
                case 2:
                    removeTopLog();
                    break;
                case 3:
                    clearLogs();
                    break;
                case 4:
                    checkIfEmpty();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


class PizzaOrderQueue {
    private Queue<String> pizzaOrders;

    public PizzaOrderQueue() {
        pizzaOrders = new LinkedList<>();
    }

    public void addOrder(String order) {
        pizzaOrders.add(order);
        System.out.println("Order added: " + order);
    }

    public void showOrderProgress() {
        if (pizzaOrders.isEmpty()) {
            System.out.println("No orders in the queue.");
        } else {
            System.out.println("Order progress:");
            for (String order : pizzaOrders) {
                System.out.println(order);
            }
        }
    }

    public void processNextOrder() {
        if (!pizzaOrders.isEmpty()) {
            String order = pizzaOrders.poll();
            System.out.println("Processing order: " + order);
        } else {
            System.out.println("No orders in the queue.");
        }
    }

    public void handleQueue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pizza Order Queue Operations:");
            System.out.println("1. Add order");
            System.out.println("2. Show order progress");
            System.out.println("3. Process next order");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1 - 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the order details (pizza, side, drink): ");
                    String order = scanner.nextLine();
                    addOrder(order);
                    break;
                case 2:
                    showOrderProgress();
                    break;
                case 3:
                    processNextOrder();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
