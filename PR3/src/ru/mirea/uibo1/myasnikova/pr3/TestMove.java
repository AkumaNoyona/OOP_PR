package ru.mirea.uibo1.myasnikova.pr3;

public class TestMove {
    public static void main(String[] args) {
        // === Задание 1: Shape ===
        Shape s1 = new Circle(5.5, "RED", false);  // Upcast
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
        System.out.println("Color: " + s1.getColor());

        Circle c1 = (Circle) s1; // Downcast
        System.out.println(c1);
        System.out.println("Radius: " + c1.getRadius());

        // Ошибка: Shape s2 = new Shape();  // Нельзя создать объект абстрактного класса

        Shape s3 = new Rectangle(2.0, 3.0, "Blue", true);
        System.out.println(s3);
        System.out.println("Area: " + s3.getArea());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println("Area: " + s4.getArea());

        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);
        System.out.println("Length: " + r2.getLength());

        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println("Side: " + sq1.getSide());

        // === Задание 2: Movable ===
        Movable m1 = new MovablePoint(0, 0, 2, 2);
        System.out.println(m1);
        m1.moveUp();
        System.out.println("After moveUp: " + m1);

        MovableCircle mc = new MovableCircle(0, 0, 1, 1, 5);
        System.out.println(mc);
        mc.moveRight();
        System.out.println("After moveRight: " + mc);

        MovableRectangle mr = new MovableRectangle(0, 0, 2, 2, 1, 1);
        System.out.println(mr);
        mr.moveDown();
        System.out.println("After moveDown: " + mr);
    }
}
