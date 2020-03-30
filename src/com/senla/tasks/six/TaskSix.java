package com.senla.tasks.six;

import com.senla.util.IUtil;
import com.senla.util.Util;

import java.util.ArrayList;
import java.util.List;

public class TaskSix {
    private List<Item> items;
    private String size;
    private IUtil util = new Util();

    //Вывод всех предметов на экран
    private void showItems(List<Item> items) {
        int count = 0;
        for (Item item : items) {
            System.out.println("Name: " + item.getName() + " Weight: " + item.getWeight() +
                    " Price: " + item.getPrice());
            count++;
        }
    }

    //Поиск оптимального набора
    private void findSet() {
        Bag bag = new Bag(Integer.parseInt(size));
        bag.allSets(items);
        List<Item> result = bag.getBestItems();
        if (result == null) {
            System.out.println("Impossible to find the optimal set!");
        } else {
            System.out.println();
            System.out.println("Optimal set: ");
            showItems(result);
        }
    }

    //Ввод всех данных и вывод их на экран
    private void input() {
        String name, number, weight, price;

        //Ввод количества предметов
        do {
            do {
                System.out.println("Enter the number of items:");
                number = util.getIn().nextLine();
            } while (!util.checkString(number));
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 15) {
                System.out.println("The number must be in the range from 1 to 15! Try again!");
            }
        } while (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 15);

        //Ввод данных каждого предмета
        items = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(number); i++) {
            do {
                System.out.println("Enter the name of item [" + (i + 1) + "]: ");
                name = util.getIn().nextLine();
                System.out.println("Enter the weight of item [" + (i + 1) + "]: ");
                weight = util.getIn().nextLine();
                System.out.println("Enter the price of item [" + (i + 1) + "]: ");
                price = util.getIn().nextLine();
                if (!util.checkString(weight) || !util.checkString(price) ||
                        Integer.parseInt(weight) < 1 || Integer.parseInt(price) < 1)
                    System.out.println("Incorrect value! Enter the integer numbers > 0!");
            } while (!util.checkString(weight) || !util.checkString(price) ||
                    Integer.parseInt(weight) < 1 || Integer.parseInt(price) < 1);
            items.add(new Item(name, Integer.parseInt(weight), Integer.parseInt(price)));
        }

        //Ввод размера рюкзака
        do {
            System.out.println("Enter the size of bag: ");
            size = util.getIn().nextLine();
            if (!util.checkString(size)) {
                System.out.println("Incorrect value! Try again!");
            }
        } while (!util.checkString(size));
    }

    public void runTaskSix() {
        System.out.println("Calculation of the most valuable cargo for a backpack " +
                "based on the weight and durability of all items.");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    input();
                    System.out.println("List of all items: ");
                    showItems(items);
                    findSet();
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
