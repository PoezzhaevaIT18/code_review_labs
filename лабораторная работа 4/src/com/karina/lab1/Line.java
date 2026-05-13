package com.karina.lab1;

public class Line {

    //FIX_ME: Поля должны быть окончательными, потому что они не меняются после создания.
    //private Point start;
    //private Point end;

    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    //FIX_ME: При возврате значения типа int теряется точность; Google Style запрещает ненужное сужение типов
    //public int length() {
    //    double deltaX = end.getX() - start.getX();
    //    double deltaY = end.getY() - start.getY();
    //    return (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    //}

    public double length() {
        final double deltaX = end.getX() - start.getX();
        final double deltaY = end.getY() - start.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Line from " + start + " to " + end;
    }
}