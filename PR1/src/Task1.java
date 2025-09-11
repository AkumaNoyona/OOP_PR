public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {5, 8, 12, 3, 7, 15, 9, 6, 4, 10};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Среднее арифметическое: " + average);
        System.out.printf("Среднее арифметическое (форматированное): %.0f\n", average);
    }
}