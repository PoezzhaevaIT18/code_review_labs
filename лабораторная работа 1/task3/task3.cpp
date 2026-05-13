#include <iostream>
#include "Header3.h"

int main() {
    setlocale(LC_ALL, "ru");

    int k, n;

    //FIX_ME: добавлены проверки на ошибки
    std::cout << "Введите систему счисления K (2–10): ";
    std::cin >> k;

    if (k < 2 || k > 10) {
        std::cout << "Ошибка: K должно быть от 2 до 10\n";
        return 0;
    }

    std::cout << "Введите количество разрядов N (2–19): ";
    std::cin >> n;

    if (n <= 1 || n >= 20) {
        std::cout << "Ошибка: N должно быть от 2 до 19\n";
        return 0;
    }

    if (n + k >= 26) {
        std::cout << "Ошибка: условие N + K < 26 нарушено\n";
        return 0;
    }

    ZeroResult result = solve_k_numbers(k, n);

    std::cout << "Количество чисел, содержащих более трёх подряд идущих нулей: "
        << result.count << "\n";

    return 0;
}
