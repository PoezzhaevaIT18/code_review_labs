#include "Header4.h"
#include <string>

/*
    Выражение без пробелов:
        T
        F
        And(<expr>,<expr>)
        Or(<expr>,<expr>)
*/

// FIX_ME: using namespace std запрещён Google Style

bool IsValidExpression(const std::string& s) {
    // FIX_ME: раньше не было проверки на недопустимые символы
    for (char c : s) {
        if (c == ' ') return false; // пробелы запрещены
        if (!(c == 'T' || c == 'F' || c == '(' || c == ')' ||
            c == ',' || c == 'A' || c == 'n' || c == 'd' ||
            c == 'O' || c == 'r')) {
            return false; // недопустимый символ
        }
    }
    return true;
}

bool Eval(const std::string& s, int& i) {

    if (i >= s.length())
        return false;

    // T → True
    if (s[i] == 'T') {
        i++;
        return true;
    }

    // F → False
    if (s[i] == 'F') {
        i++;
        return false;
    }

    // And(...)
    if (s.compare(i, 4, "And(") == 0) {
        i += 4;  // пропускаем "And("

        int before_left = i;
        bool left = Eval(s, i);

        // если подвыражение ничего не съело и вернуло false → ошибка
        if (!left && i == before_left)
            return false;

        // FIX_ME: раньше не проверяли наличие запятой
        if (i >= s.length() || s[i] != ',')
            return false;
        i++;

        int before_right = i;
        bool right = Eval(s, i);

        if (!right && i == before_right)
            return false;

        // FIX_ME: раньше не проверяли наличие ')'
        if (i >= s.length() || s[i] != ')')
            return false;
        i++;

        return left && right;
    }

    // Or(...)
    if (s.compare(i, 3, "Or(") == 0) {
        i += 3;  // пропускаем "Or("

        int before_left = i;
        bool left = Eval(s, i);

        if (!left && i == before_left)
            return false;

        if (i >= s.length() || s[i] != ',')
            return false;
        i++;

        int before_right = i;
        bool right = Eval(s, i);

        if (!right && i == before_right)
            return false;

        if (i >= s.length() || s[i] != ')')
            return false;
        i++;

        return left || right;
    }

    // FIX_ME: раньше неверные фрагменты считались F, теперь — ошибка
    return false;
}
