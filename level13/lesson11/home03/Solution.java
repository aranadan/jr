package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/


import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));


       InputStream reader = new FileInputStream(d.readLine());
        while (reader.available() > 0)
        {

            System.out.print((char)reader.read());
        }

        reader.close();
        d.close();


    }
}