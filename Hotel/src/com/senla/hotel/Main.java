package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.util.DI.BeanFactory;
import com.senla.hotel.util.DI.annotation.Autowired;
import com.senla.hotel.util.DI.stereotype.Component;
import com.senla.hotel.util.data.Data;

@Component
public class Main {
    @Autowired
    private static MenuController menuController;
    @Autowired
    private static Data data;

    public static void setMenuController(MenuController menuController) {
        Main.menuController = menuController;
    }

    public static void setData(Data data) {
        Main.data = data;
    }

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.init();
        data.load();
        menuController.run();
    }
}
