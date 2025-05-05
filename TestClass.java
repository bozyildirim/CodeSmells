public class TestClass {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    
    // Long method with multiple responsibilities
    public void processUserData(String input) {
        // Parse input
        String[] parts = input.split(",");
        name = parts[0];
        age = Integer.parseInt(parts[1]);
        address = parts[2];
        phone = parts[3];
        email = parts[4];
        
        // Validate data
        if (name.length() < 2) {
            System.out.println("Name too short");
        }
        if (age < 0 || age > 120) {
            System.out.println("Invalid age");
        }
        if (!address.contains("@")) {
            System.out.println("Invalid address");
        }
        if (phone.length() != 10) {
            System.out.println("Invalid phone");
        }
        if (!email.contains("@")) {
            System.out.println("Invalid email");
        }
        
        // Format data
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        address = address.trim();
        phone = phone.replaceAll("[^0-9]", "");
        email = email.toLowerCase();
        
        // Save to database
        System.out.println("Saving user: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
    
    // Feature envy - this method uses another class's data more than its own
    public void printUserInfo(User otherUser) {
        System.out.println("User Details:");
        System.out.println("Name: " + otherUser.getName());
        System.out.println("Age: " + otherUser.getAge());
        System.out.println("Address: " + otherUser.getAddress());
        System.out.println("Phone: " + otherUser.getPhone());
        System.out.println("Email: " + otherUser.getEmail());
        System.out.println("Last Login: " + otherUser.getLastLogin());
        System.out.println("Account Status: " + otherUser.getAccountStatus());
    }
}

class User {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String lastLogin;
    private String accountStatus;
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getLastLogin() { return lastLogin; }
    public String getAccountStatus() { return accountStatus; }
} 