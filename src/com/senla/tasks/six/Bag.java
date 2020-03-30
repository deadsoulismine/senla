package com.senla.tasks.six;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> bestItems = null;
    private double maxWeight;
    private double bestPrice;

    public Bag(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getBestItems() {
        return bestItems;
    }

    public void setBestItems(List<Item> bestItems) {
        this.bestItems = bestItems;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(double bestPrice) {
        this.bestPrice = bestPrice;
    }

    //Общий вес набора предметов
    private double findWeight(List<Item> items) {
        double sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.getWeight();
        }
        return sumWeight;
    }

    //Общая стоимость набора предметов
    private double findPrice(List<Item> items) {
        double sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }

    //Проверка, является ли данный набор лучшим решением задачи
    private void checkSet(List<Item> items) {
        if (bestItems == null) {
            if (findWeight(items) <= maxWeight) {
                bestItems = items;
                bestPrice = findPrice(items);
            }
        } else {
            if (findWeight(items) <= maxWeight && findPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = findPrice(items);
            }
        }
    }

    //Создание всех наборов перестановок значений
    public void allSets(List<Item> items) {
        if (items.size() > 0) {
            checkSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            allSets(newSet);
        }
    }

}
