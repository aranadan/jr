package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scan.nextLine());
        byte[] buffer = new byte[inputStream.available()];
        int count = 0;
        inputStream.read(buffer);
        for (int i = 0; i < buffer.length; i++){
            Integer s = Integer.valueOf(buffer[i]);
            if (s == 44){
                count++;
            }
        }
        System.out.println(count);




        inputStream.close();
        scan.close();
    }
}
