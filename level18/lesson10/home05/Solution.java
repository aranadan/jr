package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String inFile = scanner.nextLine();
        String outFile = scanner.nextLine();

        //читаю файл
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        //файл для записи
        FileWriter fileWriter = new FileWriter(outFile, true);
        String line = reader.readLine();
        String[] array = line.split(" ");
        for (int i = 0; i < array.length; i++){
            int n = Math.round(Float.parseFloat(array[i]));
            fileWriter.write(String.valueOf(n) + " ");
        }

        scanner.close();
        reader.close();
        fileWriter.close();



    }
}
