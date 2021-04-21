import java.util.*;

public class Rarest {
	public static int rarest(Map<String, Integer> map) {
		Iterator<String> iter1 = map.keySet().iterator();
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		while (iter1.hasNext()) {
			int next = map.get(iter1.next());
			if (!countMap.containsKey(next))
				countMap.put(next, 0);
			countMap.put(next, countMap.get(next) + 1);
		}
		int min = Integer.MAX_VALUE;
		int minNum = Integer.MAX_VALUE;
		for (int i : countMap.keySet()) {
			if (countMap.get(i) < min) {
				minNum = i;
				min = countMap.get(i);
			} else if (countMap.get(i) == min && i < minNum) {
				minNum = i;
			}
		}
		return minNum;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Michael", 15);
		map.put("Jane", 21);
		map.put("Berny", 23);
		map.put("Annie", 15);
		map.put("Nicky", 23);
		map.put("Jackson", 20);
		System.out.println(rarest(map));
	}
}
