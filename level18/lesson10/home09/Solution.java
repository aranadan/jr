package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true)
            try
            {
                new FileReader(scanner.nextLine());
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
                System.out.println("переданное неправильное имя файла");
                break;

            }
        scanner.close();
    }
}
