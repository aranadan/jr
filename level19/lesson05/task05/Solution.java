package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());
        FileWriter fileWriter = new FileWriter(scanner.nextLine());
        String s = "";
        while (fileReader.ready()){
            char c = (char) fileReader.read();
            s += String.valueOf(c);
        }
        s = s.replaceAll("[\\p{Punct} \\p{Blank}]","");
        fileWriter.write(s);
        fileWriter.flush();

        scanner.close();
        fileReader.close();
        fileWriter.close();
    }
}
