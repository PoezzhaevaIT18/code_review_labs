package ru.Poezhaeva.Points;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Одномерная точка с дополнительными характеристиками.
 */
public class Point1D extends AbstractPoint {

    private double x;

    /**
     * Создаёт точку с координатой X.
     *
     * @param x координата X
     */
    public Point1D(double x) {
        super();
        this.x = x;
    }

    /**
     * Создаёт точку с координатой X и характеристиками.
     *
     * @param x координата X
     * @param color цвет точки
     * @param time время точки
     */
    public Point1D(double x, String color, String time) {
        super(color, time);
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String getCoordinates() {
        return "(" + x + ")";
    }
}
