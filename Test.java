public class TestSmell {

    // Large Class example
    private int field1;
    private int field2;
    private int field3;
    private int field4;
    private int field5;
    private int field6;
    private int field7;
    private int field8;
    private int field9;
    private int field10;

    public void method1() {
    }

    public void method2() {
    }

    public void method3() {
    }

    public void method4() {
    }

    public void method5() {
    }

    public void method6() {
    }

    public void method7() {
    }

    public void method8() {
    }

    public void method9() {
    }

    public void method10() {
    }

    // Long Method example
    public void tooLongMethod() {
        System.out.println("Start");
        // Simulating a long method with unnecessary local variables
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        int h = 8;
        int i = 9;
        int j = 10;
        System.out.println("End");
    }

    // Feature Envy example
    private String data;

    public TestSmell(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String processData() {
        // Accessing data from same class (originally it was Feature Envy)
        return getData().toUpperCase() + getData().length();
    }

    public static void main(String[] args) {
        TestSmell smell = new TestSmell("hello");
        smell.tooLongMethod();
        System.out.println(smell.processData());
    }
}
