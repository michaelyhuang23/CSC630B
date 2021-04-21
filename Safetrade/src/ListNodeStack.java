
import java.util.EmptyStackException;

public class ListNodeStack {
	private ListNode top;

	public ListNodeStack() {
		top = null;
	}

	public void push(Object value) {
		top = new ListNode(value, top);
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Object peek() {
		try {
			return top.getValue();
		} catch (Exception e) {
			throw new EmptyStackException();
		}
	}

	public Object pop() {
		try {
			Object value = top.getValue();
			top = top.getNext();
			return value;
		} catch (Exception e) {
			throw new EmptyStackException();
		}
	}

}
