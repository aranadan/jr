package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 04.03.2016.
 */
public class UkrainianHen extends Hen{
    int getCountOfEggsPerMonth(){return 9;}
    String getDescription(){
        return "Моя страна - " + UKRAINE + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
