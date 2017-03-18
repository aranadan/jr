package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String[] files = new String[3];

        for (int i = 0; i < files.length; i++){
            files[i] = scanner.nextLine();
        }
        //read second file
        FileInputStream inputStream = new FileInputStream(files[1]);
        byte[] array1 = new byte[inputStream.available()];
        inputStream.read(array1);

        //read third file
        FileInputStream inputStream3 = new FileInputStream(files[2]);
        byte[] array2 = new byte[inputStream3.available()];
        inputStream3.read(array2);

        //write to first file
        FileOutputStream outputStream = new FileOutputStream(files[0]);
        outputStream.write(array1);
        outputStream.write(array2);

        inputStream.close();
        inputStream3.close();
        outputStream.close();
        scanner.close();
    }
}
