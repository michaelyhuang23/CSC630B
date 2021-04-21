import java.util.*;
public class ListAppender {
	/***
	 * In this class, the method "append" appends all elements in list2 to list1
	 * Author: Michael Huang
	 */
	
	public <E> void append (List<E> list1, List<E> list2) {
		/***
		 * This method, accepting two list objects of arbitrary yet the same type, 
		 * appends all elements from list2 to list1 using indices
		 */
		
		for (E obj : list2) 
			list1.add(obj);
		
	}
	
	public static void main(String[] args) {
		List<String> l1=new LinkedList<String>();
		List<String> l2=new LinkedList<String>();
		l1.add("hello");
		l1.add("world");
		l2.add("bye");
		l2.add("nation");
		new ListAppender().append(l1,l2);
		System.out.print("l1 is here: "+l1+" l2 is here: "+l2);
		
	}
}
