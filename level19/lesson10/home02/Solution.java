package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader(args[0]);
        Scanner scanner = new Scanner(fr);
        Map<String, Double> collection = new HashMap<>();
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            Double summ = Double.parseDouble(array[1]);
            if (collection.containsKey(array[0]))
            {
                summ = summ + collection.get(array[0]);
                collection.remove((array[0]));
                collection.put(array[0], summ);
            } else
            {
                collection.put(array[0], summ);
            }
        }
        List<Double> list = new ArrayList(collection.values());
        Collections.sort(list);
        for (Map.Entry<String,Double> iterator : collection.entrySet()){
            if (iterator.getValue() == list.get(list.size()-1)){
                System.out.println(iterator.getKey());
            }
        }
        scanner.close();
        fr.close();
    }
}
