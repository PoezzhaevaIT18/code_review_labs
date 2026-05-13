package com.karina.lab1;

public class Point {

    //FIX_ME: Поля должны быть окончательными, потому что они не меняются после создания.
    //private double x;
    //private double y;

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{ " + x + "; " + y + " }";
    }
}
