package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());
        FileWriter fileWriter = new FileWriter(scanner.nextLine());
        String s = "";
        while (fileReader.ready()){
            char  c = (char) fileReader.read();
            s += String.valueOf(c);
        }
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++){

            if (array[i].matches("[1-9]+")){
                fileWriter.write(array[i] + " ");
            }
            fileWriter.flush();
        }
        scanner.close();
        fileReader.close();
        fileWriter.close();
    }
}
