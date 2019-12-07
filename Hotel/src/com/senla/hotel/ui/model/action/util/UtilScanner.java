package com.senla.hotel.ui.model.action.util;

import com.senla.hotel.ui.exception.TypeException;

import java.util.Scanner;

public class UtilScanner {
    public static String stringScanner() {
        Scanner in = new Scanner(System.in);
        do {
            try {
                if (!in.hasNextLine()) {
                    throw new TypeException("Enter the right field!");
                } else {
                    return in.nextLine();
                }
            } catch (TypeException e) {
                System.out.println(e.getMessage());
                in.next();
            }
        } while (in.hasNextLine());
        return in.nextLine();
    }

    public static int intScanner() {
        Scanner in = new Scanner(System.in);
        do {
            try {
                if (!in.hasNextInt()) {
                    throw new TypeException("Enter the right field!");
                } else {
                    return in.nextInt();
                }
            } catch (TypeException e) {
                System.out.println(e.getMessage());
                in.next();
            }
        } while (!in.hasNextInt());
        return in.nextInt();
    }

}
