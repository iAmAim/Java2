package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeRobot implements Robot{

	public void addRobot(Robot r){
		this.robotList.add(r);
	}
	
	private List<Robot> robotList = new ArrayList<>();
	@Override
	public void move(int x, int y) {
		for(Robot r : robotList){
			r.move(x, y);
		}
	}

}
