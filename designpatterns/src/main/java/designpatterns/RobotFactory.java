package designpatterns;

import java.lang.reflect.Proxy;

import profile.Profile;
import profile.Profiler;

public class RobotFactory {

	public static Robot createRobot(String name) {
		Robot robot = new SimpleRobot(name);
		// TODO: check for @Profile annotation
		if(robot.getClass().isAnnotationPresent(Profile.class)){
			Profiler profiler  = new Profiler(robot);
			robot = (Robot)Proxy.newProxyInstance(profiler.getClass().getClassLoader(), new Class[]{Robot.class}, profiler);
		}
		return robot;
	}
}
