/**
 * This program is written for the project English-Spanish Dictionary
 * Author: Michael Huang
 */


import java.util.*;

/**
 * This class is built for the project English-Spanish Dictionary
 * Author: Michael Huang
 */
public class Dictionary {
	
	/**
	 * This function takes in 3 parameters: the first one being a dictionary, the
	 * second one a word and the third one the word's translation. The function will
	 * add the translation to the word if the word exists in the dictionary and
	 * create a new entry for that word then add the translation if the word didn't
	 * exist.
	 * 
	 * @param dictionary
	 * @param word
	 * @param translation
	 */
	public static void add(Map<String, Set<String>> dictionary, String word, String translation) {
		if (!dictionary.containsKey(word))
			dictionary.put(word, new TreeSet<String>());
		dictionary.get(word).add(translation);
	}
	
	/**
	 * This method reverses the input dictionary That is, for all words associated
	 * with one translation, it outputs a dictionary containing that translation as
	 * a word and all the words as its translations.
	 */
	public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary) {
		Map<String, Set<String>> reverseDict = new TreeMap<String, Set<String>>();
		for (String key : dictionary.keySet())
			for (String translation : dictionary.get(key))
				Dictionary.add(reverseDict, translation, key);
		return reverseDict;
	}

}
