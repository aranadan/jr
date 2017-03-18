package com.javarush.test.level09.lesson08.task04;

import java.io.IOException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution {
    public static void main(String[] args) throws NoSuchFieldException

    {
        processExceptions(new Solution());

    }

    public static void processExceptions(Solution obj) throws NoSuchFieldException
    {
        try
        {
            obj.method1();
            obj.method2();
            obj.method3();
        }
        catch (RemoteException re)
        {
            System.out.println(re.getClass().getName());
        }
        catch (NoSuchFieldException ne)
        {
            System.out.println(ne.getClass().getName());
        }

        catch (IOException e)
        {
            System.out.println(e.getClass().getName());

        }






    }


    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
