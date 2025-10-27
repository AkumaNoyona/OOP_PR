import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        System.out.println("Введите дату для сравнения (формат YYYY-MM-DD):");
        String userInput = scanner.nextLine();

        try {
            Date userDate = dateFormat.parse(userInput);

            System.out.println("\nТекущая дата: " + dateFormat.format(currentDate));
            System.out.println("Введенная дата: " + dateFormat.format(userDate));

            System.out.print("Сравнение: ");

            int comparisonResult = userDate.compareTo(currentDate);

            if (comparisonResult < 0) {
                System.out.println("Введенная дата раньше текущей даты.");
            } else {
                System.out.println("Введенная дата позже текущей даты.");
            }

        } catch (ParseException e) {
            System.err.println("Ошибка ввода: Неверный формат даты. Используйте YYYY-MM-DD.");
        } finally {
            scanner.close();
        }
    }
}