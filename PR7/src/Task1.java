import java.util.Date;
import java.text.SimpleDateFormat;

public class Task1 {
    public static void main(String[] args) {
        String developerName = "Мясникова";

        String assignmentDateStr = "2025-10-24 09:00:00";
        SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date submissionDate = new Date();

        System.out.println("Фамилия разработчика: " + developerName);
        System.out.println("Дата и время получения задания: " + assignmentDateStr);
        System.out.println("Дата и время сдачи задания (текущее): " + fullFormat.format(submissionDate));

    }
}