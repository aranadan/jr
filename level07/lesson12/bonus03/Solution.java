package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++)
        {
            int min = array[0];
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j + 1] > min)
                {

                    int temp = array[j + 1];
                    array[j + 1] = min;
                    array[j] = temp;
                    }
                else
                min = array[j + 1];
            }
        }

    }



}
