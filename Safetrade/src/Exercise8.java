import java.util.TreeSet;

public class Exercise8 {
	public static int hashString(String text) {
		int result = 0;
		int i = 7;
		for (char letter : text.toCharArray()) {
			result += (int) letter * i;
			i += 31 * i * 2;
		}
		if (result < 0)
			result = -result;
		return result % 60;
	}

	public static void main(String[] args) {
		String text = "A hash table has sixty entries Devise and test a hash function for English words such that all the different words from this paragraph are hashed into the table with no more than four collisions Do not call any hashCode methdos";
		String[] words = text.split(" ");
		TreeSet[] hashTable = new TreeSet[60];
		for (String word : words) {
			if (hashTable[Exercise8.hashString(word)] == null)
				hashTable[Exercise8.hashString(word)] = new TreeSet<String>();
			hashTable[Exercise8.hashString(word)].add(word);
		}
		for (TreeSet<String> set : hashTable) {
			if (set == null)
				System.out.println(0);
			else
				System.out.println(set.size());
		}
	}
}
