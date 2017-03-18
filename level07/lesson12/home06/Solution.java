package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gfather1 = new Human();
        gfather1.name = "Остап";
        gfather1.age = 78;
        gfather1.sex = true;
        System.out.println(gfather1.toString());

        Human gfather2 = new Human();
        gfather2.name = "Бендер";
        gfather2.age = 77;
        gfather2.sex = true;
        System.out.println(gfather2.toString());

        Human  gmother1 = new Human();
        gmother1.name = "Раиса";
        gmother1.age = 73;
        gmother1.sex = false;
        System.out.println(gmother1.toString());

        Human  gmother2 = new Human();
        gmother2.name = "Мария";
        gmother2.age = 75;
        gmother2.sex = false;
        System.out.println(gmother2.toString());

        Human father = new Human();
        father.name = "Вася";
        father.age = 55;
        father.sex = true;
        father.father = gfather1;
        father.mother = gmother1;
        System.out.println(father.toString());

        Human  mother = new Human();
        mother.name = "Валя";
        mother.age = 53;
        mother.sex = false;
        mother.father = gfather2;
        mother.mother = gmother2;
        System.out.println(mother.toString());

        Human child1 = new Human();
        child1.name = "Аня";
        child1.age = 27;
        child1.sex = false;
        child1.father = father;
        child1.mother = mother;
        System.out.println(child1.toString());

        Human child2 = new Human();
        child2.name = "Катя";
        child2.age = 23;
        child2.sex = false;
        child2.father = father;
        child2.mother = mother;
        System.out.println(child2.toString());

        Human child3 = new Human();
        child3.name = "Андрей";
        child3.age = 29;
        child3.sex = true;
        child3.father = father;
        child3.mother = mother;
        System.out.println(child3.toString());

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
