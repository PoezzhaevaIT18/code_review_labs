package com.karina.lab1;


public class Student {

    //FIX_ME: Поля должны быть окончательными, потому что они не меняются после создания.
    //private String name;
    //private int[] grades;

    private final String name;
    private final int[] grades;

    public Student(String name, int[] grades) {

        //FIX_ME: Неглубокое копирование массива приводит к разделению состояния
        //this.grades = grades;

        this.grades = new int[grades.length];
        System.arraycopy(grades, 0, this.grades, 0, grades.length);

        this.name = name;
    }

    public void setGrade(int index, int grade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = grade;
        }
    }

    @Override
    public String toString() {

        //FIX_ME: Конкатенация строк внутри цикла неэффективна
        //String result = name + ": [";
        //for (int i = 0; i < grades.length; i++) {
        //    result += grades[i];
        //    if (i < grades.length - 1) {
        //        result += ", ";
        //    }
        //}
        //result += "]";
        //return result;

        StringBuilder result = new StringBuilder(name + ": [");
        for (int i = 0; i < grades.length; i++) {
            result.append(grades[i]);
            if (i < grades.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
