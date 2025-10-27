import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Год:");
        int year = scanner.nextInt();

        System.out.println("Введите Месяц (1-12):");
        int month = scanner.nextInt();

        System.out.println("Введите Число:");
        int day = scanner.nextInt();

        System.out.println("Введите Часы (0-23):");
        int hour = scanner.nextInt();

        System.out.println("Введите Минуты (0-59):");
        int minute = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
        System.out.println("\n--- Результат ---");
        System.out.println("Объект Calendar (toString): " + calendar.toString());
        System.out.println("Объект Date (форматир.): " + sdf.format(date));
    }
}