package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //сохрвняю введенные данные в массив
        for (int i = 0; i < 5; i++)
        {
            String s = reader.readLine();
            list.add(s);
        }

        ArrayList<String> longList = new ArrayList<String>();
        String max = list.get(0);

        // ищу самую длинную строку в списке
        for (int i = 0; i < list.size(); i++){

                String s = list.get(i);
                if (s.length() > max.length())
                    max = s;
        }



        //если в массиве есть одинаковой длинны максимальные строки добавляю их в массив
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if (s.length() == max.length())
                longList.add(s);
        }
        //вывожу содержимое массива на экран
        for (int i = 0; i < longList.size(); i++ )
            System.out.println(longList.get(i));
    }
}
