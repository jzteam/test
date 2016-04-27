package cn.jzteam.test;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JzteamWarning {
	String[] value() default "jzteam test";
}
