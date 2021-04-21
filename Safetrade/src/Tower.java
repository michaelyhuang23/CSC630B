
import java.util.*;

public class Tower implements Stack_Self {
	/***
	 * This class is built for Question 12 of Java Methods chapter 22 Author:
	 * Michael Huang
	 */
	LinkedList<Disk> tower;

	public Tower() {
		/***
		 * construct a new empty tower
		 */
		tower = new LinkedList<Disk>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tower.isEmpty();
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return tower.getLast();
	}

	@Override
	public void push(Object obj) {
		// TODO Auto-generated method stub
		tower.addLast((Disk) obj);
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		return tower.removeLast();
	}

	public Tower flip() {
		/***
		 * Destroy the current tower and return the reverse of the current tower
		 */
		Tower newTower = new Tower();
		while (!tower.isEmpty())
			newTower.push(tower.pop());
		return newTower;
	}

	public String toString() {
		return tower.toString();
	}
}
