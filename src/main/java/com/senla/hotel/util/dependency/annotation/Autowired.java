package com.senla.hotel.util.dependency.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    String className() default "null";
}