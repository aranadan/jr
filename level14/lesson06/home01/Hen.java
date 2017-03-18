package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 04.03.2016.
 */
abstract class Hen implements Country
{
    abstract int getCountOfEggsPerMonth();

    String getDescription(){
        return "Я курица.";
    }
}