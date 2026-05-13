package ru.Poezhaeva.Points;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Двумерная точка с дополнительными характеристиками.
 */
public class Point2D extends AbstractPoint {

    private double x;
    private double y;

    /**
     * Создаёт точку (x, y) без характеристик.
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point2D(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * Создаёт точку (x, y) с характеристиками.
     *
     * @param x координата X
     * @param y координата Y
     * @param color цвет точки
     * @param time время точки
     */
    public Point2D(double x, double y, String color, String time) {
        super(color, time);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String getCoordinates() {
        return "(" + x + ", " + y + ")";
    }
}
