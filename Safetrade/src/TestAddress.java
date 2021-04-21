import java.util.*;

public class TestAddress {
	public void splitStack(Stack<Integer> stack) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int length = 0;
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
			length++;
		}
		for (int index = 0; index < length; index++) {
			int nextElement = queue.peek();
			if (nextElement < 0)
				stack.push(queue.remove());
			else
				queue.add(queue.remove());
		}
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			stack.push(rand.nextInt(100) - 50);
		}
		System.out.println(stack);
		TestAddress tester = new TestAddress();
		tester.splitStack(stack);
		System.out.println(stack);
	}
}
