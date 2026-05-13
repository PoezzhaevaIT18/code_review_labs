package ru.Poezhaeva.LineComparison;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Класс, представляющий линию между двумя точками Point1.
 */
public class Line2 {

    private Point1 start;
    private Point1 end;

    /**
     * Создаёт линию по двум точкам.
     *
     * @param start начальная точка
     * @param end конечная точка
     */
    public Line2(Point1 start, Point1 end) {

        // FIX_ME(Нужно копировать точки, чтобы избежать aliasing)
        // this.start = start;
        // this.end = end;

        this.start = new Point1(start.getX(), start.getY());
        this.end = new Point1(end.getX(), end.getY());
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Line2)) {
            return false;
        }

        Line2 other = (Line2) obj;

        return start.getX() == other.start.getX()
                && start.getY() == other.start.getY()
                && end.getX() == other.end.getX()
                && end.getY() == other.end.getY();
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
