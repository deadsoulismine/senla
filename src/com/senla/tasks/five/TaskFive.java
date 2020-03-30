package com.senla.tasks.five;

import com.senla.util.IUtil;
import com.senla.util.Util;

import java.util.Scanner;

public class TaskFive {
    private String size;
    private IUtil util = new Util();

    //Ввод размера последовательности
    private void input() {
        do {
            do {
                System.out.println("Enter the integer number from 0 to 100: ");
                size = util.getIn().nextLine();
            } while (!checkString(size));
            if (Integer.parseInt(size) < 0 || Integer.parseInt(size) > 100)
                System.out.println("The number must be in the range from 0 to 100! Try again!");
        } while (Integer.parseInt(size) < 0 || Integer.parseInt(size) > 100);
    }

    //Проверка на палиндром
    private boolean palindrome(String string) {
        int len = string.length();
        for (int i = 0; i < len / 2; i++) {
            if (string.codePointAt(i) != string.codePointAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //Поиск палиндромов в последовательности
    private void findPalindrome() {
        System.out.println("Palindrome numbers from a given sequence: ");
        for (int i = 0; i <= Integer.parseInt(size); i++) {
            if (palindrome(String.valueOf(i)))
                System.out.println(i);
        }
    }

    //Проверка введённых данных
    private boolean checkString(String s) {
        //на пустую строку
        if (!util.checkEmptyString(s)) {
            System.out.println("You entered an empty string! Try again!");
            return false;
        }
        //на строку имеющую не только числа
        else if (!util.tryParseInt(s)) {
            System.out.println("Enter only a number! Try again!");
            return false;
        } else
            return true;
    }

    public void runTaskFive () {
        System.out.println("Search for palindrome numbers in a given sequence.");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    input();
                    findPalindrome();
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
