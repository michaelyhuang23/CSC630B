import java.util.*;


public class helloworld {
	public static void main(String[] args)
	{
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(3);
		stk.push(5);
		stk.push(6);
		System.out.println(stk.peek());
		System.out.println(stk.size());
		for(int i=0;i<stk.size();i++) 
			System.out.println(stk.pop()+" ");
		stk.push(3);
		stk.push(5);
		stk.push(6);
		int si=stk.size();
		System.out.println();
		for(int i=0;i<si;i++) 
			System.out.println(stk.pop()+" ");
		System.out.println((5)%1.5);
		
	}
}
