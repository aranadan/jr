package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/

import java.util.ArrayList;

public class Solution
{

    static ArrayList<Integer> array = new ArrayList<Integer>();
    static Integer armstrong = null;
    private static boolean isNumberUnique(int number)
            {
                int lastDigit = 0;
                int currentDigit;

                while (number > 0)
                {
                    currentDigit = number % 10;
                    if (lastDigit > currentDigit)
                    {
                        return false;
                    }
                    lastDigit = currentDigit;
                    number /= 10;
                }

                return true;
            }

            private static boolean isArmstrongNumber(int number) {
                 armstrong = sum(number);
                if (armstrong == sum(armstrong)) {
                    return true;

                }

                return false;
            }

            public static int sum(int a) {
                int addition = 0;
                int d = ("" + a).length();
                int b = a % 10;
                while (a >= 1) {
                    addition += Math.pow(b, d);
                    a /= 10;
                    b = a % 10;
                }
                return addition;
            }


            public static int[] getNumbers(int N)
            {
                ArrayList<Integer> tmp = new ArrayList<Integer>();

                for (int i = 1; i <= N; i++){
                    if (isNumberUnique(i)){
                        tmp.add(i);
                    }
                }
                for (int i = 0; i < tmp.size(); i++){

                    if (isArmstrongNumber(tmp.get(i))){

                        if (!array.contains(armstrong))
                        {
                            array.add(armstrong);
                        }
                    }
                }

                int[] result = new int[array.size()];

                for(int i = 0; i < array.size();i++)
                {
                    result[i] = array.get(i).intValue();
                }
                return result;
        }


            public static void main(String[] args)
            {
                Solution s = new Solution();
                long start = System.currentTimeMillis();
                for (int q : getNumbers(999999999)){
                    System.out.println(q);
                }
                long end = System.currentTimeMillis() - start; // считаю сколько секунд длилась "программа"
                long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // считаю сколько памяти было занято.
                System.out.println("Time = " + end / 1000);
                System.out.println("Memory = " + memory / 1048576);
            }
        }
