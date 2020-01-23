package com.senla.hotel.util.DI;

import java.util.Map;

public interface IBeanFactory {
    void init() throws ReflectiveOperationException;

    Object instantiateInstance(String instanceName);

    Object getBean(String changeRoomPriceAction);

    void instantiateSingletons();

    Map<String, Object> getSingletons();
}
