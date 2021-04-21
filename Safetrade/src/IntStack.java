
import java.util.EmptyStackException;

public class IntStack {
	private int[] stack;
	private int stackPointer;
	private static int defaultSize = 8;

	public IntStack() {
		stack = new int[defaultSize];
		stackPointer = 0;
	}

	public IntStack(int size) {
		stack = new int[size];
		stackPointer = 0;
	}

	private boolean hasSpace() {
		return stack.length > stackPointer;
	}

	public void reallocate() {
		int[] newStack = new int[stack.length * 2];
		for (int i = 0; i < stack.length; i++)
			newStack[i] = stack[i];
		stack = newStack;
		newStack = null;
	}

	public boolean empty() {
		return stackPointer < 1;
	}

	public int peek() {
		try {
			return stack[stackPointer - 1];
		} catch (Exception e) {
			throw new EmptyStackException();
		}
	}

	public int push(int item) {
		if (!hasSpace())
			reallocate();
		stack[stackPointer] = item;
		stackPointer++;
		return item;
	}

	public int pop() {
		try {
			stackPointer--;
			return stack[stackPointer];
		} catch (Exception e) {
			stackPointer++;
			throw new EmptyStackException();
		}
	}

}
