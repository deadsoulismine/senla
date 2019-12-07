package com.senla.hotel.backend.repository.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Service;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaveService {
    public static void fileSaveService(String name) {
        try (FileWriter fileWriter = new FileWriter(name)) {
            for (Service service : Application.getHotel().serviceList()) {
                fileWriter.write((service.getPrice()) + ", ");
                fileWriter.write((service.getName()) + ", ");
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
