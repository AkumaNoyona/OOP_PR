import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

public class Student {
    private String name;
    private Date dateOfBirth;

    public Student(String name, String dobString) {
        this.name = name;
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOfBirth = defaultFormat.parse(dobString);
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга даты рождения. Использована текущая дата.");
            this.dateOfBirth = new Date();
        }
    }

    public String getFormattedDateOfBirth(String formatString) {
        if (dateOfBirth == null) {
            return "Дата рождения не установлена";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formatString, Locale.getDefault());
        return formatter.format(dateOfBirth);
    }

    // Переопределяем метод toString()
    @Override
    public String toString() {
        String shortFormatDOB = getFormattedDateOfBirth("dd.MM.yyyy");
        return "Student [Name=" + name + ", DateOfBirth=" + shortFormatDOB + "]";
    }

    public static void main(String[] args) {
        Student student = new Student("Мясникова", "2005-05-26");

        System.out.println(student.toString());

        System.out.println("Дата рождения (короткий): " +
                student.getFormattedDateOfBirth("dd.MM.yy"));
        System.out.println("Дата рождения (средний): " +
                student.getFormattedDateOfBirth("dd MMMM yyyy"));
        System.out.println("Дата рождения (полный): " +
                student.getFormattedDateOfBirth("EEEE, d MMMM yyyy"));
    }
}