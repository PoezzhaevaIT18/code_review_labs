package ru.Poezhaeva.Points;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Абстрактный класс точки с дополнительными характеристиками:
 * цвет и время.
 */
public abstract class AbstractPoint {

    // FIX_ME(Поля были protected без необходимости — заменено на private)
    // protected String color;
    // protected String time;
    private String color;
    private String time;

    /**
     * Конструктор по умолчанию — задаёт значения по умолчанию.
     */
    public AbstractPoint() {
        this.color = "без цвета";
        this.time = "неизвестно";
    }

    /**
     * Конструктор с характеристиками.
     *
     * @param color цвет точки
     * @param time время создания или отметки
     */
    public AbstractPoint(String color, String time) {
        this.color = color;
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public String getTime() {
        return time;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Возвращает строковое представление координат точки.
     *
     * @return координаты точки в строковом виде
     */
    public abstract String getCoordinates();

    @Override
    public String toString() {
        return getCoordinates() + ", цвет: " + color + ", время: " + time;
    }
}
