#ifndef HEADER4_H_
#define HEADER4_H_

#include <string>

// FIX_ME: раньше функции не были вынесены в заголовок Ч нарушало структуру проекта
// новый код: корректные объ€влени€

bool Eval(const std::string& s, int& i);
bool IsValidExpression(const std::string& s);

#endif
