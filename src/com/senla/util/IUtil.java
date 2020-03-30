package com.senla.util;

import com.senla.tasks.five.TaskFive;
import com.senla.tasks.four.TaskFour;
import com.senla.tasks.one.TaskOne;
import com.senla.tasks.six.TaskSix;
import com.senla.tasks.three.TaskThree;
import com.senla.tasks.two.TaskTwo;

import java.util.Scanner;

public interface IUtil {
    TaskOne getTaskOne();

    TaskTwo getTaskTwo();

    TaskThree getTaskThree();

    TaskFour getTaskFour();

    TaskFive getTaskFive();

    TaskSix getTaskSix();

    Scanner getIn();

    boolean tryParseInt(String value);

    String enter();

    boolean checkEmptyString(String str);

    boolean checkString(String s);

    void runMenu();
}
