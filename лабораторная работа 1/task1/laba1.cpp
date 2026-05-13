#include <iostream>
#include "Header.h"
/*
Эта программа решает задачу:
Нужно выбрать подмножество артефактов так,
чтобы суммарный вес был в диапазоне [A, B],
а суммарный объём — минимальным.
Используется динамическое программирование.
*/

int main() {
    setlocale(LC_ALL, "ru");

    ArtifactResult result = solve_artifacts("f.txt");

    if (result.indices.empty()) {
        std::cout << "Подходящих артефактов нет.\n";
        return 0;
    }

    std::cout << "Минимальный объём: " << result.total_volume << "\n";
    std::cout << "Суммарный вес: " << result.total_weight << "\n";
    std::cout << "Артефакты:\n";

    for (int index : result.indices) {
        std::cout << index << "\n";
    }

    return 0;
}
