package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(scanner.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while (input.available() > 0)
        {
            int tmp = input.read();
            if (map.containsKey(tmp))
            {
                map.put(tmp, map.get(tmp)+1);
            }
            else
            {
                map.put(tmp, 1);
            }
        }

            for (Map.Entry<Integer, Integer> q : map.entrySet()){
                if (q.getValue() > max){max = q.getValue();}
            }

            for (Map.Entry<Integer, Integer> m : map.entrySet()){
                if (m.getValue() == max)
                {
                    System.out.print(m.getKey() + " ");
                }
        }
        input.close();
    }
}
