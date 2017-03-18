package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Cat Tom = new Cat(5,"Tom", "grey");
        Dog Spike = new Dog(5, 70, "Spike");
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog
    {
        int age, weight;
        String name;
        public Dog(int age, int weight,  String name){
            this.age = age;
            this.weight= weight;
            this.name = name;

        }
    }
    public static class Cat
    {
        int age;
        String name;
        String color;
        public Cat(int age, String name, String color)
        {
            this.age = age;
            this.name = name;
            this.color = color;
        }
    }

}
