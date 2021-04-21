
public class LookupState {
	public static String[] stateNames = new String[676];

	public static void add(String abbr, String name) {
		stateNames[lookupIndex(abbr)] = name;
	}

	public static String find(String abbr) {
		return stateNames[lookupIndex(abbr)];
	}

	private static int lookupIndex(String abbr) {
		return ((int) (abbr.charAt(0)) - 65) * 26 + ((int) (abbr.charAt(1)) - 65);
	}

	public static void main(String[] args) {
		LookupState.add("MA", "Massachussetts");
		LookupState.add("ZZ", "Connecticut");
		System.out.println(LookupState.find("MA"));
		System.out.println("k;jlhgjfhjklhkjghjkhkgjhjkhgjhjklhgfyghjhjjkhjgjhkugjkgjvkjjvkjhgjfhugyu".hashCode()%16);
		"MA".hashCode();
	}
}
