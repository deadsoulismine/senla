package com.senla.tasks.four;

import com.senla.util.IUtil;
import com.senla.util.Util;

import java.util.Locale;

public class TaskFour {
    private String text, word;
    private IUtil util = new Util();

    //Ввод текста
    private void inputText() {
        System.out.println("Enter the text: ");
        text = util.getIn().nextLine();
        text = text.trim();
        text = text.toLowerCase(new Locale("ru", "RU"));
    }

    //Ввод искомого слова
    private void inputWord() {
        System.out.println("Enter the word, which need to find: ");
        word = util.getIn().nextLine();
        word = word.toLowerCase(new Locale("ru", "RU"));
    }

    //Поиск количества раз вхождения слова в текст
    private void find() {
        int count = 0;
        String[] words = text.split("[ ,.!?]");
        for (String string : words) {
            if (string.equals(word))
                count++;
        }
        System.out.println("The number of times the search word appears in the text: " + count);
    }

    public void runTaskFour() {
        System.out.println("Counting the number of times a word is used in the text (case-insensitive).");
        String check = "Y";
        boolean flag = true;
        do {
            switch (check) {
                case "Y":
                    do {
                        inputText();
                        if (util.checkEmptyString(text)) {
                            do {
                                inputWord();
                                if (util.checkEmptyString(word)) {
                                    find();
                                } else {
                                    System.out.println("You didn't enter the word for find!");
                                }
                            } while (!util.checkEmptyString(word));
                        } else {
                            System.out.println("You didn't enter the text!");
                        }
                    } while (!util.checkEmptyString(text));
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
