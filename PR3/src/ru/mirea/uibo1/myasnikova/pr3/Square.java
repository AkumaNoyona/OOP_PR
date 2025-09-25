package ru.mirea.uibo1.myasnikova.pr3;

public class Square extends Rectangle {

    public Square() {

    }

    public Square(double side) {
       this.width = side;
    }

    public Square(double side, String color, boolean filled) {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.length = side;
        this.width = side;
    }

    public void setWidth(double side) {
        this.width = side;
        this.length = side;
    }

    public void setLength(double side) {
        this.length = side;
        this.width = side;
    }

    public String toString() {
        return "Square[side=" + length + ", color=" + color + ", filled=" + filled + "]";
    }
}

