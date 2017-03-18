package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());
        Scanner scannerFr = new Scanner(fileReader);
        while (scannerFr.hasNext()){
            String tmp = scannerFr.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tmp);
            stringBuilder = stringBuilder.reverse();
            System.out.println(stringBuilder);
        }
        scanner.close();
        scannerFr.close();
        fileReader.close();

    }
}
