package com.fashion.spv.validated.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证 是否为数字
 * String
 */
@Documented
@Target({  FIELD,PARAMETER })
@Retention(RUNTIME)
public @interface Digits {


    String msg() default "com.spv.valid.Digits.msg";

}
