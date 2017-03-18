package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/



import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner = new Scanner(new FileReader(fileName));
        FileWriter fileWriter = new FileWriter(fileName,true);
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        String space = " ";
        ArrayList<Integer> list = new ArrayList<>();
        Integer newId=1;


        //search id
        while (scanner.hasNext()){

            String idString = scanner.nextLine().substring(0,8);
            String idWithoutSpace = "";

            for (int i = 0; i < 8; i++){

                String symbol = idString.substring(i,i+1);
                if (!symbol.equals(" ")){
                    idWithoutSpace += symbol;
                }
            }

            list.add(Integer.valueOf(Integer.parseInt(idWithoutSpace)));
        }
        scanner.close();


        Collections.sort(list);
        if (list.size() < 1){list.add(newId);}
        else {
            newId = list.get(list.size()-1)+1;
        }


            if (newId.toString().length() > 8)
            {
                fileWriter.write(newId.toString(), 0, 8);

            } else
            {
                String StringId = newId.toString();
                while (StringId.length() < 8)
                {
                    StringId += space;
                }
                fileWriter.write(StringId);
            }

        //write productName
        if (productName.length() > 30){
            fileWriter.write(productName,0,30);
        }
        else
        {
            while(productName.length() < 30){
                productName += space;
            }
            fileWriter.write(productName);
        }

        //write price
        if (price.length()>8){
            fileWriter.write(price,0,8);
        }
        else
        {
            while (price.length() < 8){
                price += space;
            }
            fileWriter.write(price);
        }

        //write quantity
        if (quantity.length() > 4){
            fileWriter.write(quantity,0,4);
        }else
        {
            while (price.length() < 4){
                quantity += space;
            }
            fileWriter.write(quantity);
        }
        fileWriter.write("\r\n");
        fileWriter.flush();
        fileWriter.close();

    }
}
