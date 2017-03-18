package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        byte[] array = new byte[inputStream.available()];
        byte[] array2 = new byte[inputStream2.available()];
        inputStream.read(array);
        inputStream2.read(array2);

        FileOutputStream outputStream = new FileOutputStream(file1,false); //перезаписывает файл
        FileOutputStream outputStream2 = new FileOutputStream(file1,true); //добавляет в файл
        outputStream.write(array2);
        outputStream2.write(array);

        inputStream.close();
        inputStream2.close();
        outputStream.close();
        outputStream2.close();
        scanner.close();
    }
}
