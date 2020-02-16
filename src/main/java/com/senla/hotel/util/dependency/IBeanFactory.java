package com.senla.hotel.util.dependency;

import java.util.Map;

public interface IBeanFactory {
    void init() throws ReflectiveOperationException;

    Object instantiateInstance(String instanceName);

    Object getBean(String changeRoomPriceAction);

    void instantiateSingletons();

    Map<String, Object> getSingletons();
}
