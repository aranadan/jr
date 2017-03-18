package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true){
            String tmpName = reader.readLine();
            if (tmpName.equals("exit")){
                break;
            }
            list.add(tmpName);

        }

        for (String s : list)
        {
            ReadThread rt = new ReadThread(s);
            rt.start();
            try
            {
                rt.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private int[] array = new int[1000];

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public  void run(){
            //считаю байты
            try
            {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0){
                    array[inputStream.read()]++;
                }
                inputStream.close();
            }
            catch (java.io.IOException e)
            {
                e.printStackTrace();
            }
            int max = 0;
            int Byte = 0;
            for (int i = 0; i < array.length; i++){

                if (array[i] > max){
                    max = array[i];
                    Byte = i;
                }
            }
            synchronized (this){
                resultMap.put(fileName, Byte);
                //System.out.print(fileName + " " + Byte);
            }




        }
    }
}
