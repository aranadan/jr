package com.javarush.test.level19.lesson10.home03;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        Scanner scanner = new Scanner(fr);

        while   (scanner.hasNext()){
            String name = "";
            String data = "";
            String[] tmp = scanner.nextLine().split(" ");
            for (int i = 0; i < tmp.length; i++){
                try {
                    int dataTemp = Integer.parseInt(tmp[i]);
                    data += dataTemp +" ";

                }catch (Exception e){
                    name += tmp[i] + " ";
                }
            }
            String[] date = data.split(" ");
            Date birthDay = new GregorianCalendar(Integer.parseInt(date[2]),Integer.parseInt(date[1])-1,Integer.parseInt(date[0])).getTime();
            PEOPLE.add(new Person(name,birthDay));

        }
        scanner.close();
        fr.close();
    }

}
