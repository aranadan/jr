package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы

    public static int max (int n, int m)
    {
        if (n > m) {return n;}
        else {return m;}
    }

    public static long max (long n, long m)
    {
        if (n > m) {return n;}
        else {return m;}
    }

    public static double max (double n, double m)
    {
        if (n > m) {return n;}
        else return m;
    }
}
