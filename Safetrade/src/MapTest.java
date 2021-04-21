/***
 * Comparing Tree map and hash map
 * Author: Michael Huang
 */

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> tmap = new TreeMap<String, String>();
		tmap.put("Michael", "454345434");
		tmap.put("Harry", "6545434543");
		tmap.put("Jack", "765434");
		tmap.put("Mary", "234543");
		tmap.put("Henry", "976543");
		for (String user : tmap.keySet())
			System.out.println(user + " -->  " + tmap.get(user));
		System.out.println();
		Map<String, String> hmap = new HashMap<String, String>(tmap);
		for (String user : hmap.keySet())
			System.out.println(user + " -->  " + hmap.get(user));
	}
}
