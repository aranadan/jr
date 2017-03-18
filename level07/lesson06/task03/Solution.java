package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> minList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //читаю с клавиатру строки и записываю их в массив
        for (int i = 0; i < 5; i++){
            String s = reader.readLine();
            list.add(s);
        }

        //нахожу строку минимальной длинны
        String min = list.get(0);
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).length() < min.length())
                min = list.get(i);
        }

        // ищу одинаковую длинну минимальных строк
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).length() == min.length())
             minList.add(list.get(i));
            //вывожу содержимое массива

        }

        for (int i =0; i < minList.size(); i++)
        {
            System.out.println(minList.get(i));
        }


    }
}
