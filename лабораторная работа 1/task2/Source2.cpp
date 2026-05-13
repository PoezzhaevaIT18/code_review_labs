#include "Header2.h"

#include <fstream>
#include <iostream>
#include <vector>
#include <climits>
//задача про черепашку - нужно вывести максимальную сумму


// FIX_ME: using namespace std — запрещено Google Style
// старый код:
// using namespace std;
// новый код: используем std::

TurtleResult solve_turtle(const std::string& input_file,
    const std::string& output_file) {
    std::ifstream file(input_file);
    std::ofstream out(output_file);

    // FIX_ME: не было проверки открытия файла
    if (!file.is_open()) {
        std::cout << "Ошибка: входной файл не найден\n";
        return { 0 };
    }

    int n;
    file >> n;

    // FIX_ME: проверка n отсутствовала
    if (!file || n <= 1 || n >= 80) {
        std::cout << "Ошибка: некорректное значение n (1 < n < 80)\n";
        return { 0 };
    }

    std::vector<std::vector<int>> board(n, std::vector<int>(n));
    std::vector<std::vector<int>> dp(n, std::vector<int>(n, 0));

    // Чтение матрицы
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!(file >> board[i][j])) {
                std::cout << "Ошибка: недостаточно данных в файле\n";
                return { 0 };
            }

            // FIX_ME: не было проверки диапазона значений
            if (board[i][j] < 0 || board[i][j] > 100) {
                std::cout << "Ошибка: элементы должны быть от 0 до 100\n";
                return { 0 };
            }
        }
    }

    file.close();

    // Старт: правый верхний угол (0, n-1)
    dp[0][n - 1] = board[0][n - 1];

    // Первая строка — движение только влево
    for (int j = n - 2; j >= 0; j--) {
        dp[0][j] = dp[0][j + 1] + board[0][j];
    }

    // Первый столбец — движение только вниз
    for (int i = 1; i < n; i++) {
        dp[i][n - 1] = dp[i - 1][n - 1] + board[i][n - 1];
    }

    // Остальные клетки
    for (int i = 1; i < n; i++) {
        for (int j = n - 2; j >= 0; j--) {
            dp[i][j] = std::max(dp[i - 1][j], dp[i][j + 1]) + board[i][j];
        }
    }

    int result = dp[n - 1][0];

    out << result;
    out.close();

    std::cout << "Максимальная сумма записана в файл: " << result << "\n";

    return { result };
}
