package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        Scanner scanner = new Scanner(fileReader);
        String s = "";
        while (scanner.hasNext()){
            String tmp = scanner.nextLine();
            String[] wordArray = tmp.split(" ");
            for (int i = 0; i < wordArray.length; i++){
                if (wordArray[i].length() > 6){
                      s += wordArray[i] + ",";
                }
            }
        }
        s = s.substring(0,s.length()-1);
        fileWriter.write(s);
        fileWriter.flush();
        fileReader.close();
        fileWriter.close();
        scanner.close();


    }
}
