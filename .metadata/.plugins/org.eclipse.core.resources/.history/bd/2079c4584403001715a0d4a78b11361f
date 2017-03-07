package profile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Profiler implements InvocationHandler {
	private Object target;

	public Profiler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		Object result = method.invoke(target, args);
		long end =System.nanoTime();
		
		Profile profile = (Profile)target.getClass().getAnnotation(Profile.class);	
		System.out.println("Profile timeunit is: " +  profile.timeUnits());
		
		double time = profile.timeUnits().equals(Profile.Units.SECONDS) ? (end-start)/1000000000.0 : (end-start)/1000000.0;
		System.out.format("Method %s took %f seconds/ms to run %n%n", method.getName(), time );
		
		return result;
	}

}
