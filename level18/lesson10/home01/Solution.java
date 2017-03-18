package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        String line = args[0];
        FileInputStream fis = new FileInputStream(line);
        while (fis.available()>0){
          Character symbol =(char) fis.read();
          if (symbol.toString().matches("[a-zA-Z]")){
                count++;
            }
        }
        System.out.println(count);
        fis.close();
    }
}
