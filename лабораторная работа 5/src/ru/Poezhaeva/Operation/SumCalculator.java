package ru.Poezhaeva.Operation;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Реализация интерфейса Summable.
 * Выполняет суммирование произвольного количества чисел.
 */
public class SumCalculator implements Summable {

    /**
     * Складывает все переданные числа.
     *
     * @param numbers массив чисел
     * @return сумма всех чисел
     */
    @Override
    public double sum(double... numbers) {
        double total = 0;
        for (double num : numbers) {
            total += num;
        }

        return total;
    }
}
