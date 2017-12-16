package com.goodidea.sso.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD,ElementType.PARAMETER})
public @interface SystemLog {

	/** 操作类型 */
	String operatorType() default "";
	
	/** 是否保存请求的参数 */
    boolean isSaveRequestData() default false;
}
