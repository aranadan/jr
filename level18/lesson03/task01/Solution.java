package com.javarush.test.level18.lesson03.task01;


import java.io.FileInputStream;
import java.util.Scanner;


/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream in = new FileInputStream(scan.nextLine());
        int max =0;
        while (in.available() > 0){
            int data = in.read();
            if (data > max){
                max = data;
            }
        }

        System.out.println(max);
       scan.close();
    }
}
