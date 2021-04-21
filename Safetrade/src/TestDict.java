
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestDict {
	public static void main(String[] args) {
		Map<String, Set<String>> dictionary = new TreeMap<String, Set<String>>();
		Dictionary.add(dictionary, "hello", "hola");
		Dictionary.add(dictionary, "hello", "buenos dias");
		Dictionary.add(dictionary, "hello", "buenos tardes");
		Dictionary.add(dictionary, "hello", "buenas noches");
		Dictionary.add(dictionary, "good morning", "hola");
		Dictionary.add(dictionary, "good morning", "buenos dias");
		System.out.println("original dictionary after added terms: ");
		System.out.println(dictionary);
		System.out.println("reverse of the original dictionary: ");
		System.out.println(Dictionary.reverse(dictionary));
	}
}
