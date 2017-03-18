package com.javarush.test.level10.lesson04.task04;

/* Задача №4 на преобразование целых типов
Добавить одну операцию по преобразованию типа, чтобы получался ответ: nine=9
short number = 9;
char zero = '0';
int nine = (zero + number);
*/

 class Test
{
    class A
    {
        String str = "ab";

        A()
        {
            printLength();
        }

        void printLength()
        {
            System.out.println(str.length());
        }
    }
}