#include "Header.h"

#include <climits>
#include <fstream>
#include <iostream>
#include <vector>

// FIX_ME: using namespace std — запрещено Google Style
// старый код:
// using namespace std;
// новый код: используем std:: 

ArtifactResult solve_artifacts(const std::string& filename) {
    std::ifstream file(filename);

    // FIX_ME: раньше не было проверки
    if (!file.is_open()) {
        std::cout << "Ошибка: файл не найден\n";
        return {};
    }

    int n, a, b;
    file >> n >> a >> b;

    // FIX_ME: раньше не было проверок
    if (!file || n <= 0 || a > b) {
        std::cout << "Ошибка: некорректные параметры входных данных\n";
        return {};
    }

    // Веса и объёмы артефактов
    std::vector<int> weights(n);
    std::vector<int> volumes(n);

    for (int i = 0; i < n; i++) {
        if (!(file >> weights[i])) {
            std::cout << "Ошибка чтения веса предмета " << i + 1 << "\n";
            return {};
        }
        if (weights[i] <= 0) {
            std::cout << "Ошибка: вес предмета " << i + 1 << " должен быть > 0\n";
            return {};
        }
    }

    for (int i = 0; i < n; i++) {
        if (!(file >> volumes[i])) {
            std::cout << "Ошибка чтения объёма предмета " << i + 1 << "\n";
            return {};
        }
        if (volumes[i] <= 0) {
            std::cout << "Ошибка: объём предмета " << i + 1 << " должен быть > 0\n";
            return {};
        }
    }

    file.close();

    // dp[w] = минимальный объём при суммарном весе w
    // FIX_ME: раньше dp назывался плохо, теперь min_volume
    std::vector<int> min_volume(b + 1, INT_MAX);
    min_volume[0] = 0;

 
    // Идём назад, чтобы не перезаписать данные текущей итерации
    for (int i = 0; i < n; i++) {
        for (int w = b; w >= weights[i]; w--) {
            if (min_volume[w - weights[i]] != INT_MAX) {
                min_volume[w] = std::min(min_volume[w],
                    min_volume[w - weights[i]] + volumes[i]);
            }
        }
    }

    int best_volume = INT_MAX;
    int best_weight = -1;

    // Ищем минимальный объём среди весов от A до B
    for (int w = a; w <= b; w++) {
        if (min_volume[w] < best_volume) {
            best_volume = min_volume[w];
            best_weight = w;
        }
    }

    if (best_weight == -1) {
        std::cout << "Решение отсутствует: невозможно набрать вес в диапазоне ["
            << a << ", " << b << "]\n";
        return {};
    }

    ArtifactResult result;
    result.total_weight = best_weight;
    result.total_volume = best_volume;

    // Восстанавливаем выбранные предметы
    std::vector<int> chosen;
    int w = best_weight;

    // FIX_ME: добавлена проверка dp[w - weights[i]] != INT_MAX
    for (int i = n - 1; i >= 0; i--) {
        if (w >= weights[i] &&
            min_volume[w - weights[i]] != INT_MAX &&
            min_volume[w] == min_volume[w - weights[i]] + volumes[i]) {
            chosen.push_back(i + 1);
            w -= weights[i];
        }
    }

    result.indices = chosen;
    return result;
}
