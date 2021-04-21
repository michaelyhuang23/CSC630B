/**
 * RadixSort: a program that sorts a LinkedList of Strings into alphabetical orders 
 * using the algorithm of radix sort.
 * 
 * Author: Michael Huang
 * Course: CSC630, Ms. Litvin
 * Due: 2020-03-06
 */

import java.util.*;

public class RadixSort {
	/*
	 * Initializes an array of Queues.
	 */
	private static void initializeTable(Queue<String>[] table) {
		for (int i = 0; i < table.length; i++)
			table[i] = new LinkedList<String>();
	}

	/**
	 * Employs radix sort to sort a linkedlist of strings into
	 * alphabetical order.
	 * 
	 * @param words are all in lower case.
	 * @return a linkedlist of String.
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
				if (word.length() <= i)
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
	
//	  public static String randomString(Random rand) { StringBuffer str = new
//	  StringBuffer(); for (int i = 0; i < rand.nextInt(23) + 2; i++)
//	  str.append((char) (rand.nextInt(26) + 65)); return str.toString(); }
//	
//	
//	  public static void main(String[] args) { 
//	     LinkedList<String> unsorted=new LinkedList<String>(); 
//	     Random rand=new Random();
//	 	 for(int i=0;i<100000;i++) unsorted.add(randomString(rand));
//	 	 System.out.println(unsorted);
//	 	 System.out.println("starts");
//	 	 sort(unsorted);
//	  	 System.out.println("finished"); 
//	  	 System.out.println(unsorted);
//	  }
	 
}
