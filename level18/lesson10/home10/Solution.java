package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/



import java.io.*;
import java.util.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        List<File> list = new ArrayList<>();
        String filePath = null;

        byte[] bytes = new byte[1000];

        while (true){

            String tmp = scanner.nextLine();
            if (tmp.equals("end")){
                break;
            }
            File file = new File(tmp);
            list.add(file);
            System.out.println(file.getAbsolutePath());
        }
        filePath = list.get(0).toString();
        FileOutputStream writer = new FileOutputStream(filePath.substring(0,filePath.lastIndexOf(".")),false);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++)
        {
            FileInputStream inputStream = new FileInputStream(list.get(i));
            int count = inputStream.read(bytes);
            writer.write(bytes,0,count);
            inputStream.close();
        }

        writer.close();
        scanner.close();

    }
}
