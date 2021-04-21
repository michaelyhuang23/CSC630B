
import java.util.*;

public class ProductionLine {
	/***
	 * This class is built for Question 12 of Java Methods chapter 22 Author:
	 * Michael Huang
	 */
	Queue<Disk> input;
	Queue<Tower> output;
	Tower robotArm;
	int lengthOuput;

	public ProductionLine() {
		/***
		 * construct a new ProductionLine with empty input, robotArm and output
		 */
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
		lengthOuput = 0;
	}

	public void addDisk(Disk disk) {
		/***
		 * add a Disk to the input queue
		 */
		input.add(disk);
	}

	public void unloadRobot() {
		/***
		 * delete all Disks in the robotArm and unload them inversely to the output
		 * queue
		 */
		output.add(robotArm.flip());
		lengthOuput++;
	}

	public Tower removeTower() {
		/***
		 * remove the last tower of the output queue and return it
		 */
		if (lengthOuput > 0) {
			lengthOuput--;
			return output.remove();
		} else
			throw new IndexOutOfBoundsException();
	}

	public int getLength() {
		/***
		 * get the length of the output queue
		 */
		return lengthOuput;
	}

	public void process() {
		/***
		 * Stack disks from the input queue into the reverse towers on the robot arm and
		 * then reverse the towers again and place them on the output queue
		 */
		while (!input.isEmpty()) {
			Disk nextDisk = input.remove();
			if (robotArm.isEmpty() || nextDisk.compareTo((Disk) (robotArm.peek())) > 0)
				robotArm.push(nextDisk);
			else {
				unloadRobot();
				robotArm.push(nextDisk);
			}
		}
		unloadRobot();
	}
}
