package ru.Poezhaeva.Geometry;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Класс, представляющий линию между двумя точками.
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Создаёт линию по координатам двух точек.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        check();
    }

    /**
     * Создаёт линию по двум точкам.
     */
    public Line(Point start, Point end) {

        // FIX_ME(Нужно копировать точки, чтобы избежать aliasing)
        // this.start = start;
        // this.end = end;

        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
        check();
    }

    /**
     * Проверяет, что начало и конец линии не совпадают.
     */
    private void check() {

        // FIX_ME(Раньше не было сообщения об ошибке)
        // if (start.getX() == end.getX() && start.getY() == end.getY()) { }

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new RuntimeException("Ошибка! (начало и конец линии совпадают)");
        }
    }

    /**
     * Возвращает копию начальной точки.
     */
    public Point getStart() {

        // FIX_ME(Нужно возвращать копию, а не сам объект)
        // return start;

        return new Point(start.getX(), start.getY());
    }

    /**
     * Возвращает копию конечной точки.
     */
    public Point getEnd() {

        // FIX_ME(Нужно возвращать копию, а не сам объект)
        // return end;

        return new Point(end.getX(), end.getY());
    }

    /**
     * Устанавливает новую начальную точку.
     */
    public void setStart(double x, double y) {

        // FIX_ME(Не было проверки на совпадение с конечной точкой)
        if (x == end.getX() && y == end.getY()) {
            throw new RuntimeException("Ошибка! (начало не может совпадать с концом)");
        }
        this.start = new Point(x, y);
    }

    /**
     * Устанавливает новую конечную точку.
     */
    public void setEnd(double x, double y) {

        // FIX_ME(Не было проверки на совпадение с начальной точкой)
        if (x == start.getX() && y == start.getY()) {
            throw new RuntimeException("Ошибка! (конец не может совпадать с началом)");
        }
        this.end = new Point(x, y);
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
