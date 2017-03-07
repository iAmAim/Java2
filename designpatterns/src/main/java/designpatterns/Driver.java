package designpatterns;

public class Driver {

	public static void main(String[] args) {

		SimpleRobot clockwerk = new SimpleRobot("clockwerk");
		SimpleRobot techies = new SimpleRobot("techies");
		RobotObserver direWard = new RobotObserver("Dire Ward");
		RobotObserver radiantWard = new RobotObserver("Radiant Ward");
		clockwerk.register(direWard);
		clockwerk.register(radiantWard);
		techies.register(direWard);
		techies.register(radiantWard);
		clockwerk.move(12, 24);
		clockwerk.move(12, 26);
		techies.move(5, 8);
		
		CompositeRobot c = new CompositeRobot();
		c.addRobot(techies);
		c.addRobot(clockwerk);
		c.move(1, 2);
	}

}
