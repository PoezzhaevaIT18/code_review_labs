package ru.Poezhaeva.LineComparison;

import java.util.Scanner;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Класс двумерной точки, используемой в Line2.
 */
public class Point1 {

    private double x;
    private double y;

    /**
     * Создаёт точку с координатами (x, y).
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point1(double x, double y) {
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
        return "(" + x + ", " + y + ")";
    }

    /**
     * Вводит точку с клавиатуры.
     *
     * @param name имя точки (например, "Начало", "Конец")
     * @param scanner сканер для ввода
     * @return новая точка Point1
     */
    public static Point1 input(String name, Scanner scanner) {
        double x = inputDouble(name + " X", scanner);
        double y = inputDouble(name + " Y", scanner);
        return new Point1(x, y);
    }

    /**
     * Безопасный ввод числа с проверкой.
     *
     * @param prompt текст подсказки
     * @param scanner сканер для ввода
     * @return корректно введённое число
     */
    private static double inputDouble(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt + ": ");
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                return val;
            } else {
                System.out.println("Ошибка: введите число!");
                scanner.nextLine();
            }
        }
    }
}
