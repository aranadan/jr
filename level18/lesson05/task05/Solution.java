package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            FileInputStream inputStream = new FileInputStream(scanner.nextLine());
            if (inputStream.available() < 1000)
            {
                inputStream.close();
                scanner.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
