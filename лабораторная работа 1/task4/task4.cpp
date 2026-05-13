#include <iostream>
#include <string>
#include "Header4.h"

int main() {
    setlocale(LC_ALL, "ru");

    std::string s;
    std::cout << "Введите логическое выражение: ";
    std::getline(std::cin, s);

    // Проверка корректности строки
    if (!IsValidExpression(s)) {
        std::cout << "Ошибка!";
        return 0;
    }

    int i = 0;
    bool result = Eval(s, i);

    // Проверка: выражение должно быть разобрано полностью
    if (i != s.length()) {
        std::cout << "Ошибка!";
        return 0;
    }

    std::cout << (result ? "T" : "F");

}
