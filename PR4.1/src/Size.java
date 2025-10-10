// Перечисление размеров одежды
public enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);

    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }
}


interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWomen();
}

abstract class Clothes {
    Size size;
    double price;
    String color;

    Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " | Размер: " + size + " (" + size.getEuroSize() + ", " + size.getDescription() + ")" +
                " | Цвет: " + color +
                " | Цена: " + price + " руб.";
    }
}

class TShirt extends Clothes implements MenClothing, WomenClothing {
    TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Футболка для мужчины: " + this);
    }

    public void dressWomen() {
        System.out.println("Футболка для женщины: " + this);
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Штаны для мужчины: " + this);
    }

    public void dressWomen() {
        System.out.println("Штаны для женщины: " + this);
    }
}

class Skirt extends Clothes implements WomenClothing {
    Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressWomen() {
        System.out.println("Юбка для женщины: " + this);
    }
}

class Tie extends Clothes implements MenClothing {
    Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Галстук для мужчины: " + this);
    }
}


class Atelier {
    public static void dressMan(Clothes[] clothes) {
        System.out.println("=== Мужская одежда ===");
        for (Clothes c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing)c).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("=== Женская одежда ===");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing)c).dressWomen();
            }
        }
    }
}
