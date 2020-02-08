package com.senla.hotel.util.database.jdbc;

import java.sql.Connection;

public interface IConnect {
    void execute();

    Connection getConnection();
}
