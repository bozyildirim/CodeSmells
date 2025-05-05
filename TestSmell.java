import java.util.*;
import java.io.*;

public class TestSmell {
    // Too many fields (Large Class smell)
    private String data;
    private int count;
    private List<String> items;
    private Map<String, Integer> stats;
    private boolean isProcessed;
    private Date lastUpdated;
    private String[] categories;
    private int[] values;
    private double[] scores;
    private File logFile;
    private PrintWriter writer;
    private BufferedReader reader;
    private String configPath;
    private Properties config;
    private String[] headers;
    private int[] columnWidths;
    private String footer;
    private int maxRetries;
    private int timeout;
    private String[] errorMessages;
    private int[] errorCodes;
    private String[] successMessages;
    private int[] successCodes;

    // Constructor with too many parameters (Long Parameter List smell)
    public TestSmell(String data, int count, List<String> items, Map<String, Integer> stats, 
                    boolean isProcessed, Date lastUpdated, String[] categories, int[] values, 
                    double[] scores, File logFile, String configPath, String[] headers, 
                    int[] columnWidths, String footer, int maxRetries, int timeout) {
        this.data = data;
        this.count = count;
        this.items = items;
        this.stats = stats;
        this.isProcessed = isProcessed;
        this.lastUpdated = lastUpdated;
        this.categories = categories;
        this.values = values;
        this.scores = scores;
        this.logFile = logFile;
        this.configPath = configPath;
        this.headers = headers;
        this.columnWidths = columnWidths;
        this.footer = footer;
        this.maxRetries = maxRetries;
        this.timeout = timeout;
        this.errorMessages = new String[]{"Error 1", "Error 2", "Error 3"};
        this.errorCodes = new int[]{100, 200, 300};
        this.successMessages = new String[]{"Success 1", "Success 2", "Success 3"};
        this.successCodes = new int[]{0, 1, 2};
    }

    // Long method with multiple responsibilities (Long Method smell)
    public void processData() throws IOException {
        // Initialize
        initializeConfig();
        openLogFile();
        
        // Process data
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            if (item != null && !item.isEmpty()) {
                // Validate
                if (!validateItem(item)) {
                    logError("Invalid item: " + item);
                    continue;
                }
                
                // Transform
                String transformed = transformItem(item);
                
                // Calculate
                double score = calculateScore(transformed);
                
                // Update stats
                updateStats(item, score);
                
                // Log progress
                logProgress(i, items.size());
            }
        }
        
        // Finalize
        generateReport();
        closeLogFile();
    }

    // Feature Envy smell - this method uses another class's data more than its own
    public void processUserData(User user) {
        // Using User class's data extensively
        String fullName = user.getFirstName() + " " + user.getLastName();
        String email = user.getEmail();
        String address = user.getAddress().getStreet() + ", " + 
                        user.getAddress().getCity() + ", " + 
                        user.getAddress().getCountry();
        
        // More User class data usage
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            double total = order.getTotal();
            Date date = order.getDate();
            String status = order.getStatus();
            
            // Process order data
            processOrder(order);
        }
        
        // Even more User class data usage
        List<Payment> payments = user.getPayments();
        for (Payment payment : payments) {
            double amount = payment.getAmount();
            String method = payment.getMethod();
            Date date = payment.getDate();
            
            // Process payment data
            processPayment(payment);
        }
    }

    // Duplicate code smell
    private void processOrder(Order order) {
        double total = order.getTotal();
        Date date = order.getDate();
        String status = order.getStatus();
        
        // Duplicate validation logic
        if (total < 0) {
            logError("Invalid order total: " + total);
            return;
        }
        if (date == null) {
            logError("Invalid order date");
            return;
        }
        if (status == null || status.isEmpty()) {
            logError("Invalid order status");
            return;
        }
        
        // Process order
        updateStats("order", total);
    }

    // More duplicate code
    private void processPayment(Payment payment) {
        double amount = payment.getAmount();
        String method = payment.getMethod();
        Date date = payment.getDate();
        
        // Same validation logic duplicated
        if (amount < 0) {
            logError("Invalid payment amount: " + amount);
            return;
        }
        if (date == null) {
            logError("Invalid payment date");
            return;
        }
        if (method == null || method.isEmpty()) {
            logError("Invalid payment method");
            return;
        }
        
        // Process payment
        updateStats("payment", amount);
    }

    // Primitive obsession smell
    public void validateUser(String firstName, String lastName, String email, 
                           String street, String city, String country,
                           int age, double height, double weight) {
        // Too many primitive parameters
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        // ... more validation of primitive types
    }

    // Helper methods (some with Long Method smell)
    private void initializeConfig() throws IOException {
        config = new Properties();
        try (FileInputStream fis = new FileInputStream(configPath)) {
            config.load(fis);
        }
    }

    private void openLogFile() throws IOException {
        writer = new PrintWriter(new FileWriter(logFile, true));
        reader = new BufferedReader(new FileReader(logFile));
    }

    private boolean validateItem(String item) {
        return item != null && !item.isEmpty() && item.length() > 3;
    }

    private String transformItem(String item) {
        return item.toUpperCase().trim();
    }

    private double calculateScore(String item) {
        double score = 0;
        for (char c : item.toCharArray()) {
            score += c;
        }
        return score / item.length();
    }

    private void updateStats(String key, double value) {
        stats.put(key, stats.getOrDefault(key, 0) + 1);
    }

    private void logProgress(int current, int total) {
        writer.println("Progress: " + current + "/" + total);
    }

    private void logError(String message) {
        writer.println("ERROR: " + message);
    }

    private void generateReport() throws IOException {
        writer.println("=== Report ===");
        writer.println("Total items processed: " + items.size());
        writer.println("Stats: " + stats);
        writer.println("=== End Report ===");
    }

    private void closeLogFile() {
        if (writer != null) {
            writer.close();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// Supporting classes to demonstrate Feature Envy
class User {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private List<Order> orders;
    private List<Payment> payments;

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public Address getAddress() { return address; }
    public List<Order> getOrders() { return orders; }
    public List<Payment> getPayments() { return payments; }
}

class Address {
    private String street;
    private String city;
    private String country;

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getCountry() { return country; }
}

class Order {
    private double total;
    private Date date;
    private String status;

    public double getTotal() { return total; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }
}

class Payment {
    private double amount;
    private String method;
    private Date date;

    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public Date getDate() { return date; }
}
