package com.karina.lab1;

public class Main {

    //FIX_ME: магическое число(не понятно что оно обозначает)
    //Point[] points = new Point[3];

    private static final int POINT_COUNT = 3;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Examination examination = new Examination();

        Point[] points = readPoints(examination);
        printPoints(points);

        executeTask2();
        executeTask3();
        executeTask4();
        executeTask5();
    }
    // 1  Создать три точки
    private Point[] readPoints(Examination examination) {
        Point[] points = new Point[POINT_COUNT];

        for (int i = 0; i < POINT_COUNT; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ": ");

            //FIX_ME: Имя метода должно быть написано строчными буквами в стиле lowerCamelCase
            //double x = examination.Coordinate("x");
            //double y = examination.Coordinate("y");

            double x = examination.coordinate("x");
            double y = examination.coordinate("y");

            points[i] = new Point(x, y);
        }
        return points;
    }

    private void printPoints(Point[] points) {
        System.out.println("Созданные точки:");
        for (Point p : points) {
            System.out.println(p);
        }
    }

    private void executeTask2() {
        // 2.1 Линия 1 с началом в т. {1;3} и концом в т. {23;8}
        Point firstStart = new Point(1, 3);
        Point firstEnd = new Point(23, 8);
        Line line1 = new Line(firstStart, firstEnd);

        // 2.2 Линия 2, горизонтальная, на высоте 10,от точки 5 до точки 25
        Point secondStart = new Point(5, 10);
        Point secondEnd = new Point(25, 10);
        Line line2 = new Line(secondStart, secondEnd);

        // 2.3 Линия 3, которая начинается там же, где линия 1 и заканчивается там же, где линия 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Task 2.1–2.3:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // 2.4 Изменяем координаты 1 и 2 линии, но чтобы координаты 3 линии соответствовали 3 пункту
        firstStart = new Point(1, 18);
        secondEnd = new Point(15, 10);

        line1 = new Line(firstStart, firstEnd);
        line2 = new Line(secondStart, secondEnd);
        line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Task 2.4:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // 2.5 Измените координаты 1 линии так, чтобы при этом не изменились, координаты 3 линии
        firstStart = new Point(1, 18);
        firstEnd = new Point(-7, 5);
        line1 = new Line(firstStart, firstEnd);

        System.out.println("Task 2.5:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
    }

    private void executeTask3() {
        // 3.1, создать студента Васю с оценками: 3, 4, 5.
        int[] vasyaGrades = {3, 4, 5};
        Student vasya = new Student("Vasya", vasyaGrades);
        // 3.2, создать студента Петю и скопировать оценки Васи,присвоив содержимое поля с оценками Васи полю с оценками Пети.
        Student petya = new Student("Petya", vasyaGrades);
        // 3.3, заменить первую оценку Пети на число 5.
        petya.setGrade(0, 5);
        System.out.println("Task 3:");
        System.out.println(vasya);
        System.out.println(petya);
        // 3.4, создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок Васи не влияло на Андрея.
        Student andrey = new Student("Andrey", vasyaGrades);
        vasya.setGrade(0, 2);
        System.out.println(vasya);
        System.out.println(andrey);
    }

    private void executeTask4() {
        //4. 1 создать объект точки можно только путем указания обеих координат: X и Y, создать и вывести:
        Point p1 = new Point(3, 5);
        Point p2 = new Point(25, 6);
        Point p3 = new Point(7, 8);

        System.out.println("Task 4.1, вывод точек:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        //4. 2 создаем линии
        //Создание Линии возможно с указанием координат начала и конца как четырех чисел (x1,y1,x2,y2)
        Line l1 = new Line(1, 3, 23, 8);
        Line l2 = new Line(5, 10, 25, 10);
        Line l3 = new Line(l1.getStart(), l2.getEnd());

        System.out.println("Task 4.2, вывод линий:");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }

    private void executeTask5() {
        Point a = new Point(1.0, 1.0);
        Point b = new Point(10.0, 15.0);
        Line line = new Line(a, b);

        System.out.println("Task 5: длина линии = " + line.length());
    }
}
