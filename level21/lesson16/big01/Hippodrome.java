package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by root on 09.10.16.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void  main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Diablo",3,0);
        Horse horse2 = new Horse("Aldo",3,0);
        Horse horse3 = new Horse("Ryzhity",3,0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();


    }

    public ArrayList<Horse> getHorses(){
        return this.horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
            System.out.println();
            System.out.println();
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }

    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++){
            if (horses.get(i).distance > winner.getDistance()){
                winner = horses.get(i);}
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
