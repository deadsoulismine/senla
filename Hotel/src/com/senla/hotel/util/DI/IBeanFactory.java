package com.senla.hotel.util.DI;

public interface IBeanFactory {
    void init() throws ReflectiveOperationException;

    Object instantiateInstance(String instanceName) throws ReflectiveOperationException;
}
