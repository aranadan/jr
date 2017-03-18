package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 04.03.2016.
 */
public class RussianHen extends Hen{
    int getCountOfEggsPerMonth(){return 8;}
    String getDescription(){
        return "Моя страна - " + RUSSIA + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}

