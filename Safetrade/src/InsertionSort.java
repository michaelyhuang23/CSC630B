import java.util.*;

public class InsertionSort<E> {
	@SuppressWarnings("unchecked")
	public List<E> sort(List<E> list){
		ListIterator<E> iter1=list.listIterator();
		while(iter1.hasNext()) {
			E item=iter1.next();
			ListIterator<E> iter2=list.listIterator(iter1.previousIndex());
			while(iter2.hasPrevious()) {
				E prev=iter2.previous();
				if(((Comparable<E>)prev).compareTo(item)>0) {
					
					iter2.set(item);
					iter2.next();
					iter2.next();
					iter2.set(prev);
					iter2.previous();
					iter2.previous();
				}else {
					break;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		InsertionSort<Integer> sorter=new InsertionSort<Integer>();
		Random rand=new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size=1000;
		for (int i = 0; i < size; i++) 
			list.add(rand.nextInt(100000));
		System.out.println(list);
		System.out.println(sorter.sort(list));
	}
}
