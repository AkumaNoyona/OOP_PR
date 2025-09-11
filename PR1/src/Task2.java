import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        int i = 0;
        System.out.println("Введите элементы массива:");
        while (i < size) {
            numbers[i] = scanner.nextInt();
            i++;
        }
        int sum = 0;
        int j = 0;
        do {
            sum += numbers[j];
            j++;
        } while (j < size);

        int max = numbers[0];
        int min = numbers[0];

        for (int m = 1; m < size; m++) {
            if (numbers[m] > max) {
                max = numbers[m];
            }
            if (numbers[m] < min) {
                min = numbers[m];
            }
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
    }
}