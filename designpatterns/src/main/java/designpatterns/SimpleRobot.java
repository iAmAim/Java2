package designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SimpleRobot extends Observable implements Robot {

	private String name;

	private List<Observer> obs = new ArrayList<>();
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
		notifyObs();
	}

	public void register(Observer o) {
		obs.add(o);
		this.addObserver(o);
	}

	protected void notifyObs() {
		for (Observer ob : obs) {
			ob.update(this, this);
		}
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
