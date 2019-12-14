package com.senla.hotel.util;

import com.senla.hotel.ui.exception.TypeException;

import java.util.Scanner;

public class UtilScanner {
    private static Scanner in = new Scanner(System.in);

    public static String stringScanner() {
        return in.next();
    }

    public static int intScanner() {
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
