import java.util.*;
public class HashTest {
	public static void main(String[] args) {
		Random rand=new Random();
		Stack<Integer> stack=new Stack<Integer>();
		Map<Integer,Integer> sets=new HashMap<Integer,Integer>();
		for(int i=0;i<1000000;i++) {
			stack.push(rand.nextInt(100));
		}
		long time1=System.nanoTime();
		while(!stack.isEmpty()) 
			sets.put(stack.pop(),1);
		long time2=System.nanoTime();
		Iterator<Integer> iter1=sets.keySet().iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next());
		System.out.println(sets);
		System.out.println((time2-time1)/1000000000.0);
		System.out.println("ab".hashCode());

	}
}
