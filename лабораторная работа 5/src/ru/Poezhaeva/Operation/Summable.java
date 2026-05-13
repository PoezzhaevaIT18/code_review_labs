package ru.Poezhaeva.Operation;

// FIX_ME(Класс не имел JavaDoc)

/**
 * Интерфейс, определяющий операцию суммирования.
 * Демонстрация полиморфизма: разные классы могут реализовать суммирование по‑своему.
 */
public interface Summable {

    /**
     * Выполняет суммирование переданных чисел.
     *
     * @param numbers список чисел
     * @return сумма
     */
    double sum(double... numbers);
}
