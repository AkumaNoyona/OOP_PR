public class TestMathCalculable {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();
        System.out.println("Число PI из интерфейса: " + MathCalculable.PI);
        System.out.println("4^3 = " + mc1.power(4, 3));
        System.out.println("Модуль комплексного числа 3 + 4i = " +
                mc1.complexModulus(3, 4));
        System.out.println("Модуль комплексного числа 1 + 1i = " +
                mc1.complexModulus(1, 1));

        MathFunc mathFunc = new MathFunc();
        double radius = 5.0;
        System.out.println("Длина окружности радиуса " + radius + " = " +
                mathFunc.circleLength(radius));
        System.out.println("Площадь круга радиуса " + radius + " = " +
                mathFunc.circleArea(radius));
        System.out.println("Объем сферы радиуса " + radius + " = " +
                mathFunc.sphereVolume(radius));
    }

}
