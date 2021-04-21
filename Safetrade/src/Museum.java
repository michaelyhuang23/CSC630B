import java.lang.*;

public class Museum implements Place {
	private double[] position = new double[3];

	public Museum(double x, double y, double z) {
		position[0] = x;
		position[1] = y;
		position[2] = z;

	}

	public double[] getPosition() {
		return this.position;
	}

	public int distance(Place other) {
		double[] otherPos = other.getPosition();
		return (int) (Math.sqrt(Math.pow(this.position[0] - otherPos[0], 2)
				+ Math.pow(this.position[1] - otherPos[1], 2) + Math.pow(this.position[2] - otherPos[2], 2)));
	}

}
