package com.senla.tasks.two;

import com.senla.util.IUtil;
import com.senla.util.Util;

public class TaskTwo {
    private IUtil util = new Util();

    //Поиск НОД
    private int gcd(int a, int b) {
        if (b < 0) {
            b = -b;
        }
        if (a < 0) {
            a = -a;
        }
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //Поиск НОК
    private int scm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    //Проверка на ввод целого числа
    private boolean checkInt(String line) {
        //проверка пустой строки и натуральных чисел
        if (util.tryParseInt(line) && Integer.parseInt(line) > 0) {
            return true;
        } else {
            System.out.println("Enter the natural and integer numbers!");
            return false;
        }
    }

    public void runTaskTwo() {
        System.out.println("The calculated of the GCD and the SCM of two integer numbers.");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    String a, b;
                    do {
                        System.out.println("Enter the first integer number: ");
                        a = util.getIn().nextLine();
                        System.out.println("Enter the second integer number: ");
                        b = util.getIn().nextLine();
                    } while (!checkInt(a) || !checkInt(b));
                    System.out.println("GCD = " + gcd(Integer.parseInt(a), Integer.parseInt(b)));
                    System.out.println("SCM = " + scm(Integer.parseInt(a), Integer.parseInt(b)));
                    check = util.enter();
                    break;
                case "N":
                    flag = false;
                    break;
                default:
                    check = util.enter();
                    break;
            }
        } while (flag);
    }

}
