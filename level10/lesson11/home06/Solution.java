package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        int age;
        int weight;
        int height;
        String color;
        String sex;
        String hair;

        public Human(int age)
        {
            this.age = age;
        }

        public Human(int age, int weight)
        {
            this.age = age;
            this.weight = weight;
        }

        public Human(int age, int weight, int height)
        {
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
        public Human(int age, int weight, int height, String color)
        {
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.color = color;
        }
        public Human(int age, int weight, int height, String color, String sex)
        {
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.color = color;
            this.sex = sex;
        }

        public Human(int age, int weight, int height, String color, String sex, String hair)
        {
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.color = color;
            this.sex = sex;
            this.hair = hair;
        }

        public Human(int weight, int height, String color, String sex, String hair)
        {

            this.weight = weight;
            this.height = height;
            this.color = color;
            this.sex = sex;
            this.hair = hair;
        }
        public Human(int height, String color, String sex, String hair)
        {

            this.height = height;
            this.color = color;
            this.sex = sex;
            this.hair = hair;
        }
        public Human(String color, String sex, String hair)
        {

            this.color = color;
            this.sex = sex;
            this.hair = hair;
        }
        public Human( String sex, String hair)
        {

            this.sex = sex;
            this.hair = hair;
        }




    }
}
