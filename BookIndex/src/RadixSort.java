import java.util.*;

public class RadixSort {
	/**
	 * this is a private helper method that initializes an array of Queues.
	 * @param table is an array of Queues.
	 */
	private static void initializeTable(Queue<String>[] table) {
		for (int i = 0; i < table.length; i++)
			table[i] = new LinkedList<String>();
	}

	/**
	 * This methods employ radix sort to sort a linkedlist of strings into alphabetical order.
	 * @param words: all in lower case
	 * @return a linkedlist of String
	 */
	@SuppressWarnings("unchecked")
	public static LinkedList<String> sort(LinkedList<String> words) {
		Queue<String>[] sortTable = new Queue[28];
		int maxLength = 0;
		for (String word : words)
			maxLength = Math.max(word.length(), maxLength);
		for (int i = maxLength - 1; i >= 0; i--) {
			initializeTable(sortTable);
			for (String word : words) {
				if (word.length() <= i + 1)
					sortTable[0].add(word);
				else if (Character.isLetter(word.charAt(i)))
					sortTable[Character.getNumericValue(word.charAt(i)) - Character.getNumericValue('a') + 1].add(word);
				else
					sortTable[27].add(word);
			}
			words.clear();
			for (Queue<String> queue : sortTable)
				while (!queue.isEmpty())
					words.add(queue.remove());
		}
		return words;
	}

	
	// this is created for demonstration purposes
	/*
	public static String randomString(Random rand) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < rand.nextInt(23) + 2; i++)
			str.append((char) (rand.nextInt(26) + 65));
		return str.toString();
	}*/
	/*
	 * public static void main(String[] args) { LinkedList<String> unsorted=new
	 * LinkedList<String>(); Random rand=new Random(); for(int i=0;i<10;i++)
	 * unsorted.add(randomString(rand)); System.out.println(unsorted);
	 * System.out.println(sort(unsorted)); }
	 */
}
