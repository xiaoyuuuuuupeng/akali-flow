package com.sqg.flow.annotion;

import java.lang.annotation.*;
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NodeConfig {

    String name() default "";
}
