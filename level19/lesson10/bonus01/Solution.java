package com.javarush.test.level19.lesson10.bonus01;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        Scanner scannerFile = new Scanner(System.in);
        FileReader f1 = new FileReader(scannerFile.nextLine());
        FileReader f2 = new FileReader(scannerFile.nextLine());
        Scanner scannerf1 = new Scanner(f1);
        Scanner scannerf2 = new Scanner(f2);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        while (scannerf1.hasNext()){
            list1.add(scannerf1.nextLine());
        }
        while (scannerf2.hasNext()){
            list2.add(scannerf2.nextLine());
        }

        int s1 = 0;
        int s2 = 0;
        while (s1 < list1.size()&& s2 < list2.size() ){
            if (list1.get(s1).equals(list2.get(s2))){
               writeSame(list1.get(s1));
                s1++;
                s2++;

            }
        }

        scannerf1.close();
        scannerf2.close();
        scannerFile.close();

        f1.close();
        f2.close();


    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
     static void writeAdd (String s){
        lines.add(new LineItem(Type.ADDED,s));
    }
    static void writeSame(String s){
        lines.add(new LineItem(Type.SAME,s));
    }
    static void writeRemoved(String s){
        lines.add(new LineItem(Type.REMOVED,s));
    }
}
