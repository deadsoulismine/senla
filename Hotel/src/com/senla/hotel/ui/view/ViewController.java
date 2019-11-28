package com.senla.hotel.ui.view;

import com.senla.hotel.ui.model.menu.Menu;
import com.senla.hotel.ui.model.menu.MenuItem;

public class ViewController {

    public void printTitle(Menu currentMenu) {
        System.out.println(currentMenu.getTitle());
    }

    public void printList(Menu currentMenu) {
        for (MenuItem n : currentMenu.getItems()) {
            System.out.println(n.getTitle());
        }
    }

    /*

    public void printRoomList(Hotel hotel, RoomMethods roomMethods) {
        Arrays.asList(hotel.roomList());
        //Вывод существующих комнат на экран
        System.out.println("Список существующих номеров: ");
        for (Room room : hotel.roomList()) {
            System.out.println("Номер: " + room.getNumber() + " | Стоимость: " + room.getPrice() +
                    " | " + roomMethods.free(room) + " | " + roomMethods.status(room));
        }
    }

    public String checkPrint(Object object) {
        if (!Optional.ofNullable(object).isPresent()) {
            return "[Не указано]";
        } else {
            return object.toString();
        }
    }

    */

}
