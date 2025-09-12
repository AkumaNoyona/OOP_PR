package ru.mirea.uibo1.myasnikova.pr1;
import java.util.Scanner;

public class Task4 {

    public static long calculateFactorial(int number) {
        if (number < 0) {
            return -1;
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void testFactorial() {
        System.out.println("Тест метода вычисления факториала");
        int[] testNumbers = {0, 1, 5, 7, 10, -3};
        for (int num : testNumbers) {
            long result = calculateFactorial(num);
            if (result == -1) {
                System.out.println("Факториал " + num + ": отрицательное число");
            } else {
                System.out.println("Факториал " + num + " = " + result);
            }
        }
    }

    public static void Factorial() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        long result = calculateFactorial(number);

        if (result == -1) {
            System.out.println("Число не должно быть отрицательным");
        } else {
            System.out.println("Факториал числа " + number + " = " + result);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        testFactorial();
        Factorial();
    }
}