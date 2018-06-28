package com.autoDeploy.interfaceTimer;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RequestTimesAop {

	@Autowired
	private RedisTemplate redisTemplate;

	@Pointcut("@annotation(com.autoDeploy.interfaceTimer.RequestTimes)")
	public void PointCut(){

	}

	@Before("PointCut() && @annotation(requestTimes)")
	public void ifovertime(RequestTimes requestTimes){

		try {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			//拿到request
			HttpServletRequest request = attributes.getRequest();
			String ip = request.getRemoteAddr();
			String url = request.getRequestURL().toString();
			String key = "ifovertimes".concat(url).concat(ip);
			//访问次数加一
			long count = redisTemplate.opsForValue().increment(key,1);
			//如果是第一次，则设置过期时间
			if (count == 1) {
				redisTemplate.expire(key, requestTimes.time(), TimeUnit.MILLISECONDS);
				System.out.println(requestTimes.time());
			}
			if (count > requestTimes.count()) {
				request.setAttribute("ifovertimes", "true");
			} else {
				request.setAttribute("ifovertimes", "false");
			}
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
