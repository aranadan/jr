package com.javarush.test.level04.lesson16.home03;

import java.io.*;
import java.util.Scanner;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        for(;true; )
        {
            int s = scan.nextInt();
            int sum = s;
            if (s == -1)
            {
               sum--;
                System.out.println(sum);
            }

              sum = sum +s;

        }
    }
}
