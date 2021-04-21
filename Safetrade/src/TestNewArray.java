
import java.util.*;

public class TestNewArray {
	public static void main(String[] args) {
		Dog[] dog = { new Dog(), new Dog(), new Dog() };
		Dog dog2 = new Dog();
		ArrayList<String> strs = new ArrayList<String>();
		System.out.println(System.identityHashCode(dog));
		System.out.println(System.identityHashCode(dog[0]));
		System.out.println(System.identityHashCode(dog[1]));
		System.out.println(System.identityHashCode(dog[2]));
		ListIterator<String> iter1 = strs.listIterator(2);
	}
}
