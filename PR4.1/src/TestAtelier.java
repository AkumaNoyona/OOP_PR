public class TestAtelier {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.S, 1200, "Белый"),
                new Pants(Size.M, 2500, "Синий"),
                new Skirt(Size.XXS, 1800, "Красный"),
                new Tie(Size.L, 900, "Черный"),
                new TShirt(Size.XS, 1100, "Зеленый"),
                new Pants(Size.L, 2700, "Серый")
        };

        System.out.println("=== ТЕСТ АТЕЛЬЕ ===\n");

        Atelier.dressMan(clothes);
        Atelier.dressWomen(clothes);

        System.out.println("=== ПРОВЕРКА ОПИСАНИЙ РАЗМЕРОВ ===");
        for (Size size : Size.values()) {
            System.out.printf("%s (%d): %s%n",
                    size, size.getEuroSize(), size.getDescription());
        }
    }
}
