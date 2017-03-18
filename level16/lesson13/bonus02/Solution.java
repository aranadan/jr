package com.javarush.test.level16.lesson13.bonus02;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static class N1 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {

            }
        }
    }

    static class N2 extends Thread
    {
        @Override
        public void run()
        {
            try
            {
               join();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    static class N3 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                System.out.println("Ура");
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }

    public static class N4 extends Thread implements Message
    {
        @Override
        public void run()
        {
            while (!isInterrupted())
            {
            }
        }


        public void showWarning()
        {

            try
            {
                interrupt();
                join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    static class N5 extends Thread
    {
        Scanner scan = new Scanner(System.in);

        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();

        public void run()
        {
           while(scan.hasNext())
           {
              String o = scan.nextLine();
               if (o.equals("N"))
                   break;

               try{
                   Integer i = Integer.parseInt(o);
                   result += i;
               }catch (NumberFormatException e){}

           }

            System.out.println(result);
        }




    }
    static
    {
        threads.add(new N1());
        threads.add(new N2());
        threads.add(new N3());
        threads.add(new N4());
        threads.add(new N5());
    }

    public static void main(String[] args)
    {
        Thread n = threads.get(0);
        n.start();


    }

}
