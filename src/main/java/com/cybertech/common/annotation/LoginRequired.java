package com.cybertech.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/9. 8:56 PM
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired  {
}
