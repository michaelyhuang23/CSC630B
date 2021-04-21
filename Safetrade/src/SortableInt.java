
public class SortableInt extends Number implements Comparable<SortableInt> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer value;
	private int size;
	private int max;
	private int min;

	public SortableInt(int number, int size, int min, int max) {
		value = number;
		this.size = size;
		this.min = min;
		this.max = max;
	}

	public SortableInt() {
		value = 0;
		size = 0;
		max = 0;
		min = 0;
	}

	public SortableInt(int number) {
		value = number;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setRange(int max, int min) {
		this.max = max;
		this.min = min;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long) value;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float) value;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return (double) value;
	}

	@Override
	public int compareTo(SortableInt o) {
		// TODO Auto-generated method stub
		return value - o.intValue();
	}

	public int getRange() {
		return max - min;
	}

	public int hashCode() {
		if (value == max)
			return size;
		return (int) ((value - min) * (size + 1) / getRange());
	}

	public String toString() {
		return value.toString();
	}

}