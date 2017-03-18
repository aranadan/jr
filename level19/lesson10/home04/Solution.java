package com.javarush.test.level19.lesson10.home04;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {

        Scanner scanFile = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanFile.nextLine());
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()){
            String tmp = scanner.nextLine();
            String[] wordArray = tmp.split(" ");
            int matches = 0;
            for (int i = 0; i < wordArray.length; i++){
                for (int j = 0; j < words.size(); j++){
                    if (wordArray[i].toLowerCase().equals(words.get(j).toLowerCase())){
                        matches++;
                    }
                }
            }
           if (matches == 2){
               System.out.println(tmp);
           }
        }
        scanner.close();
        fileReader.close();
        scanFile.close();

    }
}
