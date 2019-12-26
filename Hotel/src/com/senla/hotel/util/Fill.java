package com.senla.hotel.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Fill {
    String configName() default "fillGuest.properties";

    String propertyName() default "";

    ElementType type() default ElementType.FIELD;
}