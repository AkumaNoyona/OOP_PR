import java.util.*;

public class InternetShop {

    enum Category {
        ELECTRONICS("Электроника"),
        CLOTHING("Одежда"),
        BOOKS("Книги"),
        FOOD("Еда");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    static class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public boolean authenticate(String login, String password) {
            return this.login.equals(login) && this.password.equals(password);
        }
    }

    static class Product {
        private final String name;
        private final double price;
        private final Category category;

        public Product(String name, double price, Category category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public Category getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return name + " — " + price + " руб.";
        }
    }

    static class Cart {
        private final List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
            System.out.println("✔ " + product.getName() + " добавлен в корзину.");
        }

        public void showCart() {
            if (products.isEmpty()) {
                System.out.println("Корзина пуста.");
            } else {
                System.out.println("Товары в корзине:");
                for (Product p : products) {
                    System.out.println(" - " + p);
                }
            }
        }

        public double getTotal() {
            double sum = 0;
            for (Product p : products) {
                sum += p.getPrice();
            }
            return sum;
        }

        public boolean isEmpty() {
            return products.isEmpty();
        }

        public void clear() {
            products.clear();
        }
    }

    static class Store {
        private final List<Product> products = new ArrayList<>();

        public Store() {
            products.add(new Product("Смартфон", 35000, Category.ELECTRONICS));
            products.add(new Product("Ноутбук", 75000, Category.ELECTRONICS));
            products.add(new Product("Футболка", 1200, Category.CLOTHING));
            products.add(new Product("Джинсы", 2500, Category.CLOTHING));
            products.add(new Product("Роман '1984'", 800, Category.BOOKS));
            products.add(new Product("Учебник Java", 1500, Category.BOOKS));
            products.add(new Product("Шоколад", 200, Category.FOOD));
            products.add(new Product("Кофе", 450, Category.FOOD));
        }

        public void showCategories() {
            System.out.println("Категории товаров:");
            for (Category c : Category.values()) {
                System.out.println("- " + c.getDisplayName());
            }
        }

        public void showProductsByCategory(Category category) {
            System.out.println("\nТовары категории: " + category.getDisplayName());
            for (Product p : products) {
                if (p.getCategory() == category) {
                    System.out.println(" - " + p);
                }
            }
        }

        public Product findProduct(String name) {
            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(name)) {
                    return p;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("lisa", "1234"); // тестовый пользователь
        Store store = new Store();
        Cart cart = new Cart();

        System.out.println("Добро пожаловать в интернет-магазин!");
        System.out.print("Введите логин: ");
        String login = sc.nextLine();
        System.out.print("Введите пароль: ");
        String password = sc.nextLine();

        if (!user.authenticate(login, password)) {
            System.out.println("Ошибка: неверный логин или пароль!");
            return;
        }

        System.out.println("\nДобро пожаловать, " + login + "!");

        boolean running = true;
        while (running) {
            System.out.println("""
                    
                    ===== МЕНЮ =====
                    1. Просмотреть категории
                    2. Просмотреть товары категории
                    3. Добавить товар в корзину
                    4. Показать корзину
                    5. Купить товары
                    6. Выйти
                    """);
            System.out.print("Выберите пункт меню: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> store.showCategories();
                case "2" -> {
                    System.out.println("Введите название категории (Электроника, Одежда, Книги, Еда): ");
                    String catName = sc.nextLine().toUpperCase();
                    try {
                        Category category = Category.valueOf(catName);
                        store.showProductsByCategory(category);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Нет такой категории!");
                    }
                }
                case "3" -> {
                    System.out.print("Введите название товара для добавления в корзину: ");
                    String productName = sc.nextLine();
                    Product p = store.findProduct(productName);
                    if (p != null) {
                        cart.addProduct(p);
                    } else {
                        System.out.println("Товар не найден!");
                    }
                }
                case "4" -> cart.showCart();
                case "5" -> {
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста, покупка невозможна.");
                    } else {
                        double total = cart.getTotal();
                        System.out.printf("Общая сумма покупки: %.2f руб.%n", total);
                        System.out.println("Покупка успешно оформлена! Спасибо за заказ!");
                        cart.clear();
                    }
                }
                case "6" -> {
                    System.out.println("Выход из магазина. До свидания!");
                    running = false;
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
