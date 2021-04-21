
import java.util.*;

public class TestProduction {
	/***
	 * This class tests the class ProductionLine, Disk and Tower Author: Michael
	 * Huang
	 */
	public static void main(String[] args) {
		ProductionLine line = new ProductionLine();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			line.addDisk(new Disk(1 + rand.nextInt(10)));
		}
		line.process();
		while (line.getLength() > 0) {
			System.out.println(line.removeTower());
		}
	}
}
