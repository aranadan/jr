package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable
    {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;


        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }





    }

    enum Sex implements Serializable{
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person p1 = new Person("Andrey","Fox","Ukraine",Sex.MALE);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\a1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\a1.txt"));
        System.out.println(p1.firstName);
        System.out.println(p1.lastName);
        System.out.println(p1.fullName);
        System.out.println(p1.greetingString);
        System.out.println(p1.country);
        System.out.println(p1.sex);
        System.out.println(p1.outputStream);
        System.out.println(p1.logger);
        oos.writeObject(p1);
        Person p2 = (Person)ois.readObject();
        System.out.println(p2.firstName);
        System.out.println(p2.lastName);
        System.out.println(p2.fullName);
        System.out.println(p2.greetingString);
        System.out.println(p2.country);
        System.out.println(p2.sex);
        System.out.println(p2.outputStream);
        System.out.println(p2.logger);
    }

}
