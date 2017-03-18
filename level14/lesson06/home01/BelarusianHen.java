package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 04.03.2016.
 */
public class BelarusianHen extends Hen{
    int getCountOfEggsPerMonth(){return 6;}
    String getDescription(){
        return "Моя страна - " + BELARUS + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

