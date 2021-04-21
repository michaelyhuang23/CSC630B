import java.util.*;
public class ListMixer {
	/***
	 * This class includes the method "mix" that mixes two lists of strings and then return a new LinkedList object
	 * Author: Michael Huang
	 */
	
	public LinkedList<String> mix(List<String> list1, List<String> list2){
		/***
		 * This method takes in two Lists of the same size and then mix them, returning a LinkedList that
		 * is of the size of the two Lists combined
		 */
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		LinkedList<String> result = new LinkedList<String>();
		while (iter1.hasNext()) {
			result.addLast(iter1.next());
			result.addLast(iter2.next());
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<String> a=new ArrayList<String>();
		List<String> b=new ArrayList<String>();
		a.add("helloworld");
		a.add("how are you");
		b.add("are you ok");
		b.add("I am fine");
		ListMixer s=new ListMixer();
		
		System.out.print(s.mix(a, b));
	}
}
