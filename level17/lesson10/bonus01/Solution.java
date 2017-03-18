package com.javarush.test.level17.lesson10.bonus01;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
          SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person person;
        //если -c name sex bd
        if (args[0].equals("-c")){
            if (args[2].equals("м")){person = Person.createMale(args[1],dateFormat.parse(args[3]));
                allPeople.add(person);
            }
            else{person = Person.createFemale(args[1], dateFormat.parse(args[3]));
                allPeople.add(person);
            }
            System.out.println(allPeople.indexOf(person));
        }

        //если -u id name sex bd
        if (args[0].equals("-u")){
            if (args[3].equals("м")){
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(dateFormat.parse(args[4]));
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);


            }
            else {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(dateFormat.parse(args[4]));
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }

        }

        //если -d id
        if (args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);

        }
        // -i id
        if (args[0].equals("-i")){
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                    + (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " + outDateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        }

    }
}
