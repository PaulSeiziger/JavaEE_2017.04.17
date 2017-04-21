package ru.spec.ee.ejb;

import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.Priorities;

@Interceptor
//@LogTime(logResult=true)
@LogTime
@Priority(2000)
public class TimeLogger {

	public TimeLogger() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object logTime(InvocationContext ic) throws Exception {
		long ts = System.nanoTime();
		
		Object[] args = ic.getParameters();
		
		Object result = ic.proceed();
		
		Method method = ic.getMethod();
		LogTime annotation = method.getAnnotation(LogTime.class);
		if(annotation.logResult()){
			
		}
		System.out.println(""+ic.getTarget().getClass().getSimpleName()+"."
				+ method.getName()
				+ "() ---> ["
				+ result
				+ "] done in "
				+ ((System.nanoTime()-ts)/1000/1000d)+"ms");
		return result;
	}

}
