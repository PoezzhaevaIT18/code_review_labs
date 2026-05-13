package com.karina.lab1;

import java.util.Scanner;

public class Examination {

    //FIX_ME: Поле должно быть закрытым и окончательным в соответствии со стандартом Google Style
    //Scanner scanner = new Scanner(System.in);
    private final Scanner scanner = new Scanner(System.in);

    //FIX_ME: Имя метода должно быть написано строчными буквами в стиле lowerCamelCase
    //public double Coordinate(String coordinateName) {

    public double coordinate(String coordinateName) {

        while (true) {
            System.out.print("Введите координату " + coordinateName + ": ");

            if (scanner.hasNextDouble()) {
                final double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Ошибка! Пожалуйста введите число: ");
                scanner.nextLine();
            }
        }
    }
}
