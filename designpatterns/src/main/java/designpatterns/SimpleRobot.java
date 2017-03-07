package designpatterns;

import java.util.Observable;
import java.util.Observer;
import profile.Profile;
import profile.Profile.Units;

@Profile(timeUnits = Units.SECONDS)
public class SimpleRobot extends Observable implements Robot {

	private String name;
	private int lastX;
	private int lastY;

	public SimpleRobot(String name) {
		this.name = name;
	}

	public void move(int x, int y) {
		this.lastX = x;
		this.lastY = y;
		System.out.println(this.name + " is moving x=" + x + " y=" + y);
		setChanged();
		notifyObservers();
	}

	public void register(Observer o) {
		this.addObserver(o);
	}

	public String getName() {
		return name;
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

}
