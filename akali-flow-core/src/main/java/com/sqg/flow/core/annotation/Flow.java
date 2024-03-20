package com.sqg.flow.core.annotation;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Flow {
    String flowName();
    String startTime() default "";
    String el() default "";
}
