package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("qq", "ww");
        map.put("qa", "qe");
        map.put("ed", "ww");
        map.put("aa", "as");
        map.put("as", "ss");
        map.put("ss", "dd");
        map.put("sd", "sd");
        map.put("ds", "ds");
        map.put("sw", "ws");
        map.put("qs", "sw");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int n = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            if (name.equals(value)) { n++; }
        }
        return n;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int n = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();

            if (lastName.equals(key)){n++;}
        }
        return n;

    }
}
