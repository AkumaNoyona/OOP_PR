package ru.mirea.uibo1.myasnikova.pr2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(160.0, 100.0);
        System.out.println(b1);
        b1.move(90.0, 150.0);
        System.out.println(b1);
    }
}
