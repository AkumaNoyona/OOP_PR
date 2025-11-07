class Circle {
    double radius;
    static int numberOfObjects = 0;

    Circle() {
        this(1.0);
    }

    Circle (double newRadius) {
        radius = newRadius;
        numberOfObjects++;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }
}

public class TestCircleArray {
    public static void main(String[] args) {
        Circle[] circleArray = new Circle[5];

        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new Circle(i + 1.0);
        }

        Circle maxCircle = circleArray[0];
        double maxArea = maxCircle.getArea();
        int maxIndex = 0;

        for (int i = 1; i < circleArray.length; i++) {
            double currentArea = circleArray[i].getArea();

            if (currentArea > maxArea) {
                maxArea = currentArea;
                maxCircle = circleArray[i];
                maxIndex = i;
            }
        }

        System.out.println("Массив объектов Circle:");
        for (int i = 0; i < circleArray.length; i++) {
            System.out.printf("Круг [%d]: радиус = %.2f, площадь = %.2f\n",
                    i, circleArray[i].getRadius(), circleArray[i].getArea());
        }

        System.out.println("\nКруг с самой большой площадью:");
        System.out.printf("Индекс в массиве: %d\n", maxIndex);
        System.out.printf("Радиус: %.2f\n", maxCircle.getRadius());
        System.out.printf("Площадь: %.2f\n", maxArea);
    }
}