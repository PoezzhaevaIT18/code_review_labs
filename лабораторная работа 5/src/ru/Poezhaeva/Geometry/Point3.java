package ru.Poezhaeva.Geometry;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Класс трёхмерной точки.
 */
public class Point3 extends Point {

    private double z;

    /**
     * Создаёт точку (0,0,0).
     */
    public Point3() {
        super();
        this.z = 0;
    }

    /**
     * Создаёт точку с координатами (x, y, z).
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public Point3(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
