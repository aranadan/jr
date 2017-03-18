package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        String[] list = new String[3];
        for (int i=0; i < 3; i++){
            list[i] = scan.nextLine();
        }
        FileInputStream inputStream = new FileInputStream(list[0]);
        byte[] buffer = new byte[inputStream.available()];
        int result =(buffer.length / 2) + (buffer.length % 2);
        FileOutputStream outputStream = new FileOutputStream(list[1]);
        outputStream.write(buffer,0,result);
        FileOutputStream outputStream1 = new FileOutputStream(list[2]);
        outputStream1.write(buffer, result, buffer.length - result);


        inputStream.close();
        outputStream.close();
        outputStream1.close();
        scan.close();
    }

}
