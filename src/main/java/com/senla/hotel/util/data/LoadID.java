package com.senla.hotel.util.data;

import java.io.*;
import java.util.Properties;

public class LoadID {
    private static final String PATH_TO_PROPERTIES_OF_DATA = "src/main/java/com/senla/hotel/resources/config.properties";
    private static Properties propData = new Properties();
    private static FileInputStream fileInputStreamData;

    static {
        try {
            fileInputStreamData = new FileInputStream(PATH_TO_PROPERTIES_OF_DATA);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int loadGuestId() {
        try {
            propData.load(fileInputStreamData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(propData.getProperty("pathIdGuest")))) {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int loadServiceId() {
        try {
            propData.load(fileInputStreamData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader buffRead = new BufferedReader(new FileReader(propData.getProperty("pathIdService")))) {
            return Integer.parseInt(buffRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
