package com.sqg.flow.core.annotation;

import java.lang.annotation.*;
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Node {

    String name() default "";
    int isParallel() default 0;
}
