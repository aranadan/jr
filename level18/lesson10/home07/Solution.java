package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        int id = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        String n;
        String[] array;
        while (reader.ready())
        {
            n = reader.readLine();
            array = n.split(" ");
            if (id == Integer.parseInt(array[0])){
                System.out.println(n);
            }
        }
        scanner.close();
        reader.close();
    }

}
