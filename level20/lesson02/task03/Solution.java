package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    static Properties property = new Properties();

    public void fillInPropertiesMap()
    {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        try
        {
                InputStream inputStream = new FileInputStream(scanner.nextLine());
                //записываю свойства
                load(inputStream);
            }
            catch (FileNotFoundException e)
            {
               // e.printStackTrace();
                System.out.println("Oops, something wrong with my file");
            }
            catch (Exception e)
            {
                //e.printStackTrace();
                System.out.println("Oops, something wrong with save/load method");
            }
            scanner.close();

        }


        public void save(OutputStream outputStream) throws Exception {

            property.putAll(properties); // заполняю проперти значениями из пропестис
            property.store(outputStream,""); // сохраняю проперти в файл
            // /printWriter.flush();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.load(inputStream); // заполняю проперти из файла
        Set<String> list = property.stringPropertyNames(); // получаю значения ключей в список
        for (String key : list){
            properties.put(key,property.getProperty(key));
        }

    }

    public static void main(String[] args) throws Exception
    {
        Solution s = new Solution();
        s.fillInPropertiesMap();
        s.save( new FileOutputStream("d:\\a2.txt"));


    }
}
