
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackSplitter {
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
}
