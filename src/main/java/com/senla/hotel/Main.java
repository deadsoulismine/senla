package com.senla.hotel;

import com.senla.hotel.ui.controller.MenuController;
import com.senla.hotel.util.Util;
import com.senla.hotel.util.dependency.BeanFactory;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;

@Component
public class Main {
    @Autowired
    private static MenuController menuController;
    @Autowired
    private static Util util;

    public static void setUtil(Util util) {
        Main.util = util;
    }

    public static void setMenuController(MenuController menuController) {
        Main.menuController = menuController;
    }

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.init();
        util.load();
        menuController.run();
    }

}
