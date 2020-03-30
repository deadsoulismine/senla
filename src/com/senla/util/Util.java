package com.senla.util;

import com.senla.tasks.five.TaskFive;
import com.senla.tasks.four.TaskFour;
import com.senla.tasks.one.TaskOne;
import com.senla.tasks.six.TaskSix;
import com.senla.tasks.three.TaskThree;
import com.senla.tasks.two.TaskTwo;

import java.util.Scanner;

public class Util implements IUtil {
    private TaskOne taskOne;
    private TaskTwo taskTwo;
    private TaskThree taskThree;
    private TaskFour taskFour;
    private TaskFive taskFive;
    private TaskSix taskSix;
    private Scanner in = new Scanner(System.in);

    public Util() {
    }

    public Util(TaskOne taskOne, TaskTwo taskTwo, TaskThree taskThree, TaskFour taskFour, TaskFive taskFive, TaskSix taskSix) {
        this.taskOne = taskOne;
        this.taskTwo = taskTwo;
        this.taskThree = taskThree;
        this.taskFour = taskFour;
        this.taskFive = taskFive;
        this.taskSix = taskSix;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public TaskOne getTaskOne() {
        return taskOne;
    }

    public void setTaskOne(TaskOne taskOne) {
        this.taskOne = taskOne;
    }

    public TaskTwo getTaskTwo() {
        return taskTwo;
    }

    public void setTaskTwo(TaskTwo taskTwo) {
        this.taskTwo = taskTwo;
    }

    public TaskThree getTaskThree() {
        return taskThree;
    }

    public void setTaskThree(TaskThree taskThree) {
        this.taskThree = taskThree;
    }

    public TaskFour getTaskFour() {
        return taskFour;
    }

    public void setTaskFour(TaskFour taskFour) {
        this.taskFour = taskFour;
    }

    public TaskFive getTaskFive() {
        return taskFive;
    }

    public void setTaskFive(TaskFive taskFive) {
        this.taskFive = taskFive;
    }

    public TaskSix getTaskSix() {
        return taskSix;
    }

    public void setTaskSix(TaskSix taskSix) {
        this.taskSix = taskSix;
    }

    //проверка, что в строке только целые числа
    public boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Проверка ожидания
    public String enter() {
        String variable;
        do {
            System.out.println("If you want to try again, enter 'Y', " +
                    "if you want to go to the task selection menu, then 'N':");
            variable = in.nextLine();
        } while (!variable.equals("Y") && !variable.equals("N"));
        return variable;
    }

    @Override
    //Проверка строки
    public boolean checkEmptyString(String str) {
        return str.trim().length() != 0;
    }

    //Проверка введённых данных
    public boolean checkString(String s) {
        //на пустую строку
        if (!checkEmptyString(s)) {
            System.out.println("You entered an empty string! Try again!");
            return false;
        }
        //на строку имеющую не только числа
        else if (!tryParseInt(s)) {
            System.out.println("Enter only a number! Try again!");
            return false;
        } else
            return true;
    }

    public void runMenu() {
        String check;
        boolean flag = true;
        do {
            System.out.println("Task selection menu. Enter a number from 1 to 6 to start the program " +
                    "or 'exit' to exit from menu:");
            System.out.println("1 - Checking a number for: " +
                    "whether it is an integer, even or odd, and simple or compound.");
            System.out.println("2 - The calculated of the GCD and the SCM of two integer numbers.");
            System.out.println("3 - Counting the number of words in a sentence." +
                    "Output them in sorted form and change the first letter of each word to uppercase.");
            System.out.println("4 - Counting the number of times a word is used in the text (case-insensitive).");
            System.out.println("5 - Search for palindrome numbers in a given sequence.");
            System.out.println("6 - Calculation of the most valuable cargo for a backpack " +
                    "based on the weight and durability of all items");
            check = getIn().nextLine();
            switch (check) {
                case "1":
                    getTaskOne().runTaskOne();
                    break;
                case "2":
                    getTaskTwo().runTaskTwo();
                    break;
                case "3":
                    getTaskThree().runTaskThree();
                    break;
                case "4":
                    getTaskFour().runTaskFour();
                    break;
                case "5":
                    getTaskFive().runTaskFive();
                    break;
                case "6":
                    getTaskSix().runTaskSix();
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("You enter incorrect value! Try again!");
                    break;
            }

        } while (flag);
    }

}
