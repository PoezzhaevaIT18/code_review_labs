package ru.Poezhaeva.Points;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Трёхмерная точка с дополнительными характеристиками.
 */
public class Point3D extends AbstractPoint {

    private double x;
    private double y;
    private double z;

    /**
     * Создаёт точку (x, y, z) без характеристик.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public Point3D(double x, double y, double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Создаёт точку (x, y, z) с характеристиками.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     * @param color цвет точки
     * @param time время точки
     */
    public Point3D(double x, double y, double z, String color, String time) {
        super(color, time);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String getCoordinates() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
