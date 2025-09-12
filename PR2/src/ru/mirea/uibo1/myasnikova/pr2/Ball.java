package ru.mirea.uibo1.myasnikova.pr2;

public class Ball {
    private Double x = 0.0;
    private Double y = 0.0;

    public Ball(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Ball() {}

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setXY(Double x, Double y ) {
        this.x = x;
        this.y = y;
    }


}

