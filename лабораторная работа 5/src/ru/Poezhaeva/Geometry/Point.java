package ru.Poezhaeva.Geometry;

import java.util.InputMismatchException;
import java.util.Scanner;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Класс двумерной точки.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Создаёт точку (0,0).
     */
    public Point() { }

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата X
     * @param y координата Y
     */
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Безопасный ввод координаты с проверкой.
     *
     * @param name имя координаты (X, Y, Z)
     * @param scanner сканер для ввода
     * @return корректно введённое число
     */
    public static double inputCoordinate(String name, Scanner scanner) {

        // FIX_ME(После ошибки ввода буфер не очищался корректно)
        // catch (InputMismatchException e) {
        //     System.out.println("Ошибка: введите число!");
        // }

        while (true) {
            try {
                System.out.print("Введите координату " + name + ": ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число!");
                scanner.nextLine(); // очищаем буфер
            }
        }
    }
}
