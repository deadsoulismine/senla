package com.senla.hotel.util.dependency.stereotype;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String type() default "null";
}
