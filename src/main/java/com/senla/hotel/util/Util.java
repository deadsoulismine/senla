package com.senla.hotel.util;

import com.senla.hotel.util.data.IData;
import com.senla.hotel.util.database.jdbc.IConnect;
import com.senla.hotel.util.dependency.annotation.Autowired;
import com.senla.hotel.util.dependency.stereotype.Component;
import com.senla.hotel.util.mail.IMail;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class Util {
    @Autowired(className = "Data")
    private static IData data;
    @Autowired(className = "Mail")
    private static IMail mail;
    @Autowired(className = "Connect")
    private static IConnect connect;

    public void load() throws InterruptedException, ReflectiveOperationException, IOException, SQLException {
        connect.execute();
        data.load();
        mail.sendMail();
    }
}
