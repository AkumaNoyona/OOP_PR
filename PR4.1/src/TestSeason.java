public class TestSeason {
    public static void main(String[] args) {
        // 1) Переменная с любимым временем года
        Season myFav = Season.SPRING;
        System.out.println("Мое любимое время года: " + myFav);
        System.out.println("Средняя температура: " + myFav.getAverageTemp());
        System.out.println("Описание: " + myFav.getDescription());

        // 2) Метод со switch
        printLove(myFav);

        // 6) Цикл по всем временам года
        for (Season s : Season.values()) {
            System.out.println(s + " | Температура: " + s.getAverageTemp() + " | " + s.getDescription());
        }
    }

    public static void printLove(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}