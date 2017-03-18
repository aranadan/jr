package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader(args[0]);
        Scanner scanner = new Scanner(fr);
        Map<String,Double> collection = new HashMap<>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            Double summ = Double.parseDouble(array[1]);
            if (collection.containsKey(array[0])){
                summ = summ + collection.get(array[0]);
                collection.remove((array[0]));
                collection.put(array[0],summ);
            }else {
                collection.put(array[0],summ);
            }
        }
        List sortedList = new ArrayList(collection.keySet());
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++){
            System.out.println(sortedList.get(i) + " " + collection.get(sortedList.get(i)));
        }
        fr.close();
        scanner.close();
    }
}
