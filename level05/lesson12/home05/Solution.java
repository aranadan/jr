package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;

        for(; true; )
        {
            String sn = scan.readLine();


            if(sn.equals("сумма"))
            {break;}
            int n = Integer.parseInt(sn);
            s = s + n;
        }
        System.out.println(s);
    }
}
