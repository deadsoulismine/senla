package com.senla;

import com.senla.tasks.five.TaskFive;
import com.senla.tasks.four.TaskFour;
import com.senla.tasks.one.TaskOne;
import com.senla.tasks.six.TaskSix;
import com.senla.tasks.three.TaskThree;
import com.senla.tasks.two.TaskTwo;
import com.senla.util.IUtil;
import com.senla.util.Util;

public class Main {
    public static void main(String[] args) {
        IUtil utilClasses = new Util(new TaskOne(), new TaskTwo(), new TaskThree(), new TaskFour(), new TaskFive(),
                new TaskSix());
        utilClasses.runMenu();
    }

}
