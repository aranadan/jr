package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()){
            String[] tmp = scanner.nextLine().split(" ");
            for (int i = 0; i < tmp.length; i++){
                if (tmp[i].matches(".*\\d.*")){
                    fileWriter.write(tmp[i] + " ");
                }
            }
        }
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
        scanner.close();
    }
}
