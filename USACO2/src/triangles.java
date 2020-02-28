import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
ID: yhuang23
LANG: JAVA
PROB: triangles
*/
class position{
	public int x;
	public int y;
	
	public position(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int hashCode() {
		return Double.hashCode(x*x/(y*y+1));
	}
	public boolean equals(Object o) {
		return x==((position)o).x && y==((position)o).y;
	}
}
class triangles {
	public static Map<Integer, Set<Integer>> horizontalMap;
	public static Map<Integer, Set<Integer>> verticalMap; 
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("/Users/michaelhyh/Project Data/Eclipse Java/USACO2/src/triangles.in"));
		// /Users/michaelhyh/Project Data/Eclipse Java/USACO2/src/
		File file=new File("/Users/michaelhyh/Project Data/Eclipse Java/USACO2/src/triangles.out");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelhyh/Project Data/Eclipse Java/USACO2/src/triangles.out")));
		int fenceNum=Integer.parseInt(f.readLine());
		List<position> positions=new LinkedList<position>();
		horizontalMap= new HashMap<Integer, Set<Integer>>((int)(fenceNum*1.5));
		verticalMap= new HashMap<Integer, Set<Integer>>((int)(fenceNum*1.5)); 
		for(int i=0;i<fenceNum;i++) {
			String[] pos=f.readLine().split(" ",2);
			int x=Integer.parseInt(pos[0]);
			int y=Integer.parseInt(pos[1]);
			if(!horizontalMap.containsKey(y))
				horizontalMap.put(y, new TreeSet<Integer>());
			horizontalMap.get(y).add(x);
			
			if(!verticalMap.containsKey(x))
				verticalMap.put(x, new TreeSet<Integer>());
			verticalMap.get(x).add(y);
			positions.add(new position(x,y));
			pos=null;
		}
		System.out.println("firstphase");
		long totalArea=0;
		//int i=0;
		int lastX;
		long totalHori=0;
		int left=0;
		for(int y:horizontalMap.keySet()) {
			int size=horizontalMap.get(y).size();
			int min=1000000;
			for(int x:horizontalMap.get(y)) {
				min=Math.min(x, min);
				totalHori+=x-min;
			}
			lastX=0;
			for(int x:horizontalMap.get(y)) {
				totalHori+=(x-lastX)*left-(x-lastX)*(size-left);
				left++;
				long totalVerti=0;
				for(int verti:verticalMap.get(x)) {
					totalVerti+=Math.abs(verti-y);
					//i++;
				}
				totalArea+=totalHori*totalVerti;
			}
			
			
		}

		out.println(totalArea%(1000000007));
		f.close();
		out.close();
	}
}
