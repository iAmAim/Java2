package designpatterns;

import java.util.Observable;
import java.util.Observer;

public class RobotObserver implements Observer {

	private String name;
	
	RobotObserver(String name){
		this.name = name;
	}

	public void update(Observable o, Object arg) {
		if (o instanceof SimpleRobot) {
			SimpleRobot obs =  ((SimpleRobot) o);
			System.out.println(this.name+ " sees " + obs.getName() + " move to x="+obs.getLastX() + ",y="+obs.getLastY());
		}
	}

}