import java.util.*;

public class Exercise2 {
	public static List<String> sortByFirstLetter(List<String> words) {
		LinkedList<String> result = new LinkedList<String>();
		ArrayList<Queue<String>> hasher = new ArrayList<Queue<String>>();
		for (int i = 0; i < 26; i++)
			hasher.add(new LinkedList<String>());
		for (String word : words) {
			hasher.get(Character.getNumericValue(word.charAt(0)) - Character.getNumericValue('A')).add(word);
		}
		for (Queue<String> temp : hasher)
			while (!temp.isEmpty())
				result.add(temp.remove());
		return result;
	}
	
	public static void main(String[] args) {
		String[] inputs= {"Barak","Obama","Cathy","Amy","Annie","Betty"};
		LinkedList<String> list=new LinkedList<String>();
		for(int i=0;i<inputs.length;i++)
			list.add(inputs[i]);
		System.out.println(sortByFirstLetter(list));
	}
}
