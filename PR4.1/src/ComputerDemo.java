public class ComputerDemo {

    enum Brand {
        APPLE("Apple"),
        ASUS("Asus"),
        LENOVO("Lenovo"),
        HP("HP"),
        DELL("Dell");

        private final String displayName;

        Brand(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    static class Processor {
        private String model;
        private int cores;
        private double frequency; // в ГГц

        public Processor(String model, int cores, double frequency) {
            this.model = model;
            this.cores = cores;
            this.frequency = frequency;
        }

        public String getModel() {
            return model;
        }

        public int getCores() {
            return cores;
        }

        public double getFrequency() {
            return frequency;
        }

        @Override
        public String toString() {
            return String.format("%s (%d ядер, %.1f ГГц)", model, cores, frequency);
        }
    }

    static class Memory {
        private int capacity;
        private String type;

        public Memory(int capacity, String type) {
            this.capacity = capacity;
            this.type = type;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return String.format("%d ГБ %s", capacity, type);
        }
    }

    static class Monitor {
        private double size;
        private String resolution;

        public Monitor(double size, String resolution) {
            this.size = size;
            this.resolution = resolution;
        }

        public double getSize() {
            return size;
        }

        public String getResolution() {
            return resolution;
        }

        @Override
        public String toString() {
            return String.format("%.1f\" (%s)", size, resolution);
        }
    }

    static class Computer {
        private Brand brand;
        private Processor processor;
        private Memory memory;
        private Monitor monitor;
        private double price;

        public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor, double price) {
            this.brand = brand;
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
            this.price = price;
        }

        public void showInfo() {
            System.out.println("=== Компьютер ===");
            System.out.println("Марка: " + brand.getDisplayName());
            System.out.println("Процессор: " + processor);
            System.out.println("Оперативная память: " + memory);
            System.out.println("Монитор: " + monitor);
            System.out.printf("Цена: %.2f руб.%n", price);
        }

        public void start() {
            System.out.println("Компьютер " + brand.getDisplayName() + " включается...");
        }

        public void shutdown() {
            System.out.println("Компьютер " + brand.getDisplayName() + " выключается...");
        }
    }

    public static void main(String[] args) {
        Processor cpu = new Processor("Intel Core i7-13700K", 16, 3.9);
        Memory ram = new Memory(32, "DDR5");
        Monitor monitor = new Monitor(27, "2560x1440");
        Computer pc = new Computer(Brand.ASUS, cpu, ram, monitor, 18999.99);

        pc.showInfo();
        System.out.println();
        pc.start();
        pc.shutdown();
    }
}
