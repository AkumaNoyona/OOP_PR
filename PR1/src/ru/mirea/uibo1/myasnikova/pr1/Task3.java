package ru.mirea.uibo1.myasnikova.pr1;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Числа гармонического ряда:");
        for (int n = 1; n <= 10; n++) {
            double number = 0;
            for (int i = 1; i <= n; i++) {
                number += 1.0 / i;

            }
            System.out.println("Число " + n + " = " + number);
        }
    }
}