package com.javarush.test.level20.lesson07.task03;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person Andrey = new Person("Andrey","fox",29);
        Person Valentina = new Person("Valentina","fox",51);
        Person Vasiliy = new Person("Vasiliy","fox",52);
        Person Damir = new Person("Damir","fox",1);
        Andrey.setMother(Valentina);
        Andrey.setFather(Vasiliy);
        Andrey.children = new ArrayList<>();

        try
        {
            Andrey.children.add(Damir);
            System.out.println(Andrey.children.get(0).firstName);
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Oops somethink wrong");
        }
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("d:\\1.dat"));
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("d:\\1.dat"));
        Andrey.writeExternal(oo);
        Andrey.readExternal(oi);
        System.out.println(Andrey.children.get(0).firstName);


    }
}
