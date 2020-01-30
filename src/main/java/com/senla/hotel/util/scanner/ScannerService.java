package com.senla.hotel.util.scanner;

import com.senla.hotel.ui.exception.TypeException;
import com.senla.hotel.util.dependency.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerService implements IScannerService {
    private static Scanner in = new Scanner(System.in);

    public String stringScanner() {
        return in.next();
    }

    public int intScanner() {
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
