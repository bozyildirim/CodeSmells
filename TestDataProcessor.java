public class TestDataProcessor {
    // Main class for data processing
    private String data;

    public TestDataProcessor(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void printConfiguration() {
        System.out.println("Configuration values:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Value " + i + ": " + i);
        }
    }

    // Configuration class for managing values
    public static class TestConfiguration {
        private int[] values;

        public TestConfiguration() {
            this.values = new int[10];
        }

        public void setValue(int index, int value) {
            if (index >= 0 && index < values.length) {
                values[index] = value;
            }
        }

        public int getValue(int index) {
            return (index >= 0 && index < values.length) ? values[index] : 0;
        }
    }

    // Operation executor class for handling operations
    public static class TestOperationExecutor {
        private TestDataProcessor dataProcessor;
        private TestConfiguration configuration;

        public TestOperationExecutor(TestDataProcessor dataProcessor) {
            this.dataProcessor = dataProcessor;
            this.configuration = new TestConfiguration();
        }

        public void executeOperation() {
            System.out.println("Start");
            dataProcessor.printConfiguration();
            System.out.println("End");
        }
    }

    public static void main(String[] args) {
        TestDataProcessor processor = new TestDataProcessor("test");
        TestOperationExecutor executor = new TestOperationExecutor(processor);
        executor.executeOperation();
    }
} 