package com.senla.hotel.backend.repository.service;

import com.senla.hotel.backend.Application;
import com.senla.hotel.backend.domain.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoadService {
    public static void fileLoadService(String name) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] room = currentLine.split(", ");

                Application.getHotel().serviceList().add(new Service(Integer.parseInt(room[0]), room[1]));
            }
        }
    }
}

