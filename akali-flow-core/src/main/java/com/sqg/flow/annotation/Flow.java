package com.sqg.flow.annotation;

import java.lang.annotation.*;
import java.util.Map;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Flow {
    String flowName();
    String startTime() default "";
}
