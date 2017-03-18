package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream input = new FileInputStream(scan.nextLine());
        int min = input.read();
        while (input.available() > 0){
            if (input.read()< min){
                min = input.read();
            }
        }
        System.out.println(min);
        input.close();
    }
}
