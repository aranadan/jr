package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 04.03.2016.
 */
public class MoldovanHen extends Hen{

    int getCountOfEggsPerMonth() {
        return 7;
    }
    String getDescription(){
        return "Моя страна - " + MOLDOVA + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
