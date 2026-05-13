#pragma once
#ifndef HEADER2_H_
#define HEADER2_H_
#include <string>

struct TurtleResult {
    int max_sum;
};

TurtleResult solve_turtle(const std::string& input_file,
    const std::string& output_file);

#endif
