package com.autoDeploy.interfaceTimer;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestTimes {
	//单位时间允许访问次数 - - -默认值是2
	int count() default 2;

	//设置单位时间为1分钟 - - - 默认值是1分钟
	long time() default 60 * 1000;
}
