package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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
        String[] list = new String[2];
        for (int i=0; i < 2; i++){
            list[i] = scanner.nextLine();
        }
        FileInputStream inputStream = new FileInputStream(list[0]);
        FileOutputStream outputStream = new FileOutputStream(list[1]);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
       for (int i = buffer.length-1; i >= 0; i--){
           outputStream.write(buffer[i]);
       }
        scanner.close();
        inputStream.close();
        outputStream.close();



    }
}
