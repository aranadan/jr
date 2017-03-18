package com.javarush.test.level17.lesson10.home09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main  (String[] args) throws FileNotFoundException, CorruptedDataException
    {
        Scanner scan = new Scanner(System.in);
        String n1 = scan.nextLine();
        String n2 = scan.nextLine();
        scan.close();

        Scanner scan2 = new Scanner(new FileReader(n1));
        while (scan2.hasNext()){

            allLines.add(scan2.nextLine());
        }
        scan2.close();

        Scanner scan3 = new Scanner(new FileReader(n2));
        while (scan3.hasNext()){

            forRemoveLines.add(scan3.nextLine());
        }
        scan3.close();


            new Solution().joinData();


    }

    public  void joinData() throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }

        else{
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
