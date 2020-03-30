package com.senla.tasks.three;

import com.senla.util.IUtil;
import com.senla.util.Util;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class TaskThree {
    private String resText;
    private IUtil util = new Util();

    //Ввод текста
    private void inputText() {
        String text;
        String tempText;
        System.out.println("Enter the text: ");
        text = util.getIn().nextLine();
        text = text.trim();
        resText = text;
        do {
            tempText = resText;
            resText = tempText.replace("  ", " ");
        } while (!tempText.equals(resText));
    }

    //Присвоение каждому слову заглавной буквы и сортировка по алфавиту и нахождение количества слов в предложении
    private void textHandling() {
        if (util.checkEmptyString(resText)) {
            //Сортировка и количество слов
            Collator col = Collator.getInstance(new Locale("ru", "RU"));
            String[] words = resText.split("[ ,.!?]");
            String[] textArray;
            textArray = resText.split(" ");
            System.out.println("Number of words: " + textArray.length);
            Arrays.sort(words, col);
            System.out.println("Sorted words: ");
            for (String word : words) {
                if (!word.equals("")) {
                    System.out.println(word);
                }
            }

            //Заглавные буквы
            StringBuilder upperText = new StringBuilder();
            upperText.append(resText.substring(0, 1).toUpperCase()); //первый символ делаем заглавным
            for (int i = 1; i < resText.length(); i++) {
                // смотрим, был ли слева пробел:
                if (" ".equals(resText.substring(i - 1, i))) {
                    upperText.append(resText.substring(i, i + 1).toUpperCase());
                } else {
                    upperText.append(resText.substring(i, i + 1));
                }
            }
            System.out.println("All words with uppercase: " + upperText);
        } else {
            System.out.println("You didn't enter the text!");
        }
    }

    public void runTaskThree() {
        System.out.println("Counting the number of words in a sentence. Output them in sorted form " +
                "and change the first letter of each word to uppercase.");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    do {
                        inputText();
                        textHandling();
                    } while (!util.checkEmptyString(resText));
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
