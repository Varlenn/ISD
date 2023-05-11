package main.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)

public @interface ColumnString {

    String name() default "";
    int value() default 0;
    Constraints constraints() default @Constraints;
}
