package com.r.myspring.annotation;

import java.lang.annotation.*;

/**
 * @author Duands
 * @date 2020-03-12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordItemLog {

}
