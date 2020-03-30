package com.senla.tasks.one;

import com.senla.util.IUtil;
import com.senla.util.Util;

public class TaskOne {
    private IUtil util = new Util();

    //Проверка на ввод целого числа
    private boolean checkInt(String line) {
        //Проверка на присутствие в строке только числа от 2
        if (util.tryParseInt(line) && Integer.parseInt(line) > 1) {
            return true;
        } else {
            System.out.println("Enter the natural number > 1!");
            return false;
        }
    }

    //Проверка на чётность
    private void evenNumber(int variable) {
        if (variable % 2 == 0) {
            System.out.println("This number is even");
        } else {
            System.out.println("This number is odd");
        }
    }

    //Проверка на простое/составное
    private void simpleNumber(int variable) {
        for (int i = 2; i <= variable / 2; i++) {
            if (variable % i == 0) {
                System.out.println("This number is compound");
                return;
            }
        }
        System.out.println("This number is simple");
    }

    public void runTaskOne() {
        System.out.println("Checking a number for: whether it is an integer, even or odd, and simple or compound.");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    System.out.println("Enter the integer number: ");
                    String line = util.getIn().nextLine();
                    if (!checkInt(line)) {
                        do {
                            line = util.getIn().nextLine();
                        } while (!checkInt(line));
                    }
                    evenNumber(Integer.parseInt(line));
                    simpleNumber(Integer.parseInt(line));
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
