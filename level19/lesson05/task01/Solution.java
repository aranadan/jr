package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileReader file1 = new FileReader(scanner.nextLine());
        FileWriter file2 = new FileWriter(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (file1.ready()){
            list.add(file1.read());
        }
        for (int i = 1; i < list.size(); i++){
            if (i % 2 != 0){
                System.out.println(i);
                file2.write(list.get(i));
            }
        }

        file1.close();
        file2.close();
        scanner.close();
    }
}
