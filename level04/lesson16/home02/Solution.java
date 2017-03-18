package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
         //а должна быть средней
        if((a > b && a < c)||(a < b && a > c))
         {
             System.out.print(a);
         }
        //b должна быть средней
        if ((b > a && b < c)||(b < a && b > c))
        {
            System.out.print(b);
        }
        //c должна быть средней
        if ((c > a && c < b)||(c < a && c > b))
        {
            System.out.print(c);
        }
    }
}
