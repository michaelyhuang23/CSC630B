import java.util.*;


public class HashSort<E> {
	private TreeMap<E,Integer>[] referenceTable;
	private final int maxSize=10000000;
	private List<E> list;
	private double min,max;
	private int listSize;
	private int tableSize;
	private boolean isNum=false;
	private boolean isStr=false;
	public HashSort(List<E> list) {
		if(!list.isEmpty()) {
			this.list=list;
			listSize=list.size();
			tableSize=listSize;
			if(tableSize>maxSize)
				tableSize=maxSize;
			E zero=list.get(0);
			if(zero instanceof Number)
				isNum=true;
			else if(zero instanceof String)
				isStr=true;
		}
	}
	public HashSort(List<E> list, double min, double max) {
		this(list);
		setRange(min, max);
	}
	public void setRange(double min, double max) {
		/***
		 * min and max are the min and max of hashcode
		 * 
		 */
		this.min=min;
		this.max=max;
		if(max-min<listSize) 
			tableSize=(int)(max-min)+1;

	}
	@SuppressWarnings("unchecked")
	public void startSort() {
		referenceTable = (TreeMap<E, Integer>[]) new TreeMap[tableSize];
		for(int i=0;i<tableSize;i++)
			referenceTable[i]=new TreeMap<E, Integer>();
	}
	public void endSort() {
		referenceTable=null;
	}
	public List<E> hashSort(boolean startAutomatically) {
		if(startAutomatically)
			startSort();
		for(E item : list) {
			int temp;
			int hashCode=reHash(item);
			try {
				temp=referenceTable[hashCode].get(item);
			}catch(Exception e){
				temp=0;
			}
			referenceTable[hashCode].put(item, temp+1);
		}
		List<E> sortedList=new ArrayList<E>();
		for(TreeMap<E,Integer> item : referenceTable) {
			if(item.isEmpty())
				continue;
			Iterator<E> iter1=item.keySet().iterator();
			while(iter1.hasNext()) {
				E next=iter1.next();
				for(int i=0;i<item.get(next);i++)
					sortedList.add(next);
				
			}
		}
		if(startAutomatically)
			endSort();
		return sortedList;
	}
	public int reHash(E numb) {
		if(isNum) 
			return (int)((((Number)numb).doubleValue()-min-0.001)*tableSize/(max-min));
		
		if(isStr) {
			if(numb.equals(max))
				return tableSize-1;
			return (int)((((String)numb).compareTo("")-min)*tableSize/(max-min));
		}


		return 0;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSort<Integer> sorter;
		int max=0;
		int min=Integer.MAX_VALUE;
		int size=1000000;
		for (int i = 0; i < size; i++) {
			int a=rand.nextInt(100);
			if(a<min)
				min=a;
			if(a>max)
				max=a;
			list.add(a); // this value must be smaller than 1000(the value above) to ensure it to work
		}
		sorter=new HashSort<Integer>(list, (double)min, (double)max);
		//System.out.println(list);
		long startT=System.nanoTime();
		list.sort(null);
		long endT1=System.nanoTime();
		System.out.println("sorting time of sorting algorithm in java.util: "+(endT1-startT)/1000000000.0);
		sorter.hashSort(true);
		long endT2=System.nanoTime();
		System.out.println((endT2-endT1)/1000000000.0);
		//System.out.println(sorter.hashSort());
	}
}
