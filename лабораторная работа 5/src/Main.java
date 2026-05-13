// FIX_ME(Импорты были неотсортированы и без разделения на группы)
import java.util.Scanner;

import ru.Poezhaeva.Geometry.Line;
import ru.Poezhaeva.Geometry.Point;
import ru.Poezhaeva.Geometry.Point3;
import ru.Poezhaeva.LineComparison.Line2;
import ru.Poezhaeva.LineComparison.Point1;
import ru.Poezhaeva.Operation.SumCalculator;
import ru.Poezhaeva.Operation.Summable;
import ru.Poezhaeva.Points.Point1D;
import ru.Poezhaeva.Points.Point2D;
import ru.Poezhaeva.Points.Point3D;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Основной класс приложения. Содержит точку входа и логику выбора задания.
 */
public class Main {

    /**
     * Запускает программу и обрабатывает выбор пользователя.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {

        // FIX_ME(Использовался finally вместо try-with-resources)
        // Scanner scanner = new Scanner(System.in);
        // try { ... } finally { scanner.close(); }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер задания (1-8): ");

            // FIX_ME(Имя переменной num было слишком коротким)
            // int num = scanner.nextInt();
            int taskNumber = scanner.nextInt();

            switch (taskNumber) {

                // FIX_ME(Слишком большой блок кода — вынесено в метод)
                // case 1: ... много строк ...
                case 1:
                    runLineTask(scanner);
                    break;

                case 3:
                    runPoint3Task(scanner);
                    break;

                case 4:
                    runColoredPointsTask();
                    break;

                case 5:
                    runSummationTask();
                    break;

                case 6:
                    runLineComparisonTask(scanner);
                    break;

                default:
                    System.out.println("Нет такого задания.");
            }
        }
    }

    /**
     * Задание №1: создание и изменение линий.
     *
     * @param scanner сканер для ввода координат
     */
    private static void runLineTask(Scanner scanner) {
        try {
            System.out.println("Создание первой линии: ");

            double x1 = Point.inputCoordinate("X1", scanner);
            double y1 = Point.inputCoordinate("Y1", scanner);
            double x2 = Point.inputCoordinate("X2", scanner);
            double y2 = Point.inputCoordinate("Y2", scanner);

            Line line1 = new Line(x1, y1, x2, y2);
            System.out.println("Создана линия 1: " + line1);

            System.out.println("Создание второй линии: ");

            // FIX_ME(Переменные x1,y1,x2,y2 повторно использовались)
            // x1 = Point.inputCoordinate("X1", scanner);
            // y1 = Point.inputCoordinate("Y1", scanner);
            // x2 = Point.inputCoordinate("X2", scanner);
            // y2 = Point.inputCoordinate("Y2", scanner);

            double x1Second = Point.inputCoordinate("X1", scanner);
            double y1Second = Point.inputCoordinate("Y1", scanner);
            double x2Second = Point.inputCoordinate("X2", scanner);
            double y2Second = Point.inputCoordinate("Y2", scanner);

            Line line2 = new Line(x1Second, y1Second, x2Second, y2Second);
            System.out.println("Создана линия 2: " + line2);

            System.out.println("Изменим начало первой линии: ");

            double newX = Point.inputCoordinate("Новое X начала", scanner);
            double newY = Point.inputCoordinate("Новое Y начала", scanner);

            line1.setStart(newX, newY);
            System.out.println("После изменения: " + line1);

            // FIX_ME(Проверка line1.getStart() != line1.getStart() всегда false)
            // System.out.println(line1.getStart() != line1.getStart());
            System.out.println("Разные объекты: " + (line1.getStart() != line2.getStart()));

            System.out.println("Выводим линии: ");
            System.out.println(line1);
            System.out.println(line2);

        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Задание №3: работа с трёхмерной точкой Point3.
     *
     * @param scanner сканер для ввода координат
     */
    private static void runPoint3Task(Scanner scanner) {
        System.out.println("Создание точки с тремя координатами: ");

        try {
            double x = Point.inputCoordinate("X", scanner);
            double y = Point.inputCoordinate("Y", scanner);
            double z = Point.inputCoordinate("Z", scanner);

            Point3 point3D = new Point3(x, y, z);
            System.out.println("Создана точка: " + point3D);

            System.out.println("Отдельные координаты:");
            System.out.println("X = " + point3D.getX());
            System.out.println("Y = " + point3D.getY());
            System.out.println("Z = " + point3D.getZ());

            System.out.println("Изменим координату Z: ");
            double newZ = Point.inputCoordinate("новое Z", scanner);
            point3D.setZ(newZ);

            System.out.println("После изменения: " + point3D);

        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Задание №4: вывод точек с характеристиками.
     */
    private static void runColoredPointsTask() {
        Point2D p1 = new Point2D(4, 7, "жёлтый", "15:35");
        Point3D p2 = new Point3D(4, 2, 5, "синий", "11:00");
        Point2D p3 = new Point2D(3, 22);
        Point1D p4 = new Point1D(2);
        Point2D p5 = new Point2D(1, 1, "красный", "19:48");
        Point1D p6 = new Point1D(33, "коричневый", "22:22");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
    }

    /**
     * Задание №5: демонстрация интерфейса Summable.
     */
    private static void runSummationTask() {
        Summable calculator = new SumCalculator();

        double result1 = calculator.sum(2, 3.0 / 5, 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        double result2 = calculator.sum(3.6, 49.0 / 12, 3, 3.0 / 2);
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        double result3 = calculator.sum(1.0 / 3, 1);
        System.out.println("1/3 + 1 = " + result3);
    }

    /**
     * Задание №6: сравнение двух линий Line2.
     *
     * @param scanner сканер для ввода координат
     */
    private static void runLineComparisonTask(Scanner scanner) {
        System.out.println("Введите координаты первой линии:");

        Line2 line1 = new Line2(
                Point1.input("Начало", scanner),
                Point1.input("Конец", scanner)
        );

        System.out.println("Введите координаты второй линии:");

        Line2 line2 = new Line2(
                Point1.input("Начало", scanner),
                Point1.input("Конец", scanner)
        );

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);

        System.out.println(line1.equals(line2) ? "Линии одинаковые" : "Линии разные");
    }
}
