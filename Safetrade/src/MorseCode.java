
import java.util.*;

public class MorseCode {
	private final String terminator = "END";
	private Queue<String> code = new LinkedList<String>();

	public MorseCode(String[] arr) {
		for (String i : arr)
			code.add(i);

	}

	public MorseCode() {

	}

	public static String randomCode() {
		Random rand = new Random();
		String result = "";
		for (int i = 0; i < 1 + rand.nextInt(10); i++) {
			if (rand.nextBoolean())
				result += ".";
			else
				result += "-";
		}
		return result;
	}

	public void addCode(String code) {

		this.code.add(code);

	}

	public String delCode() {

		return code.remove();
	}

	public void terminateCode() {
		code.add(terminator);
	}

	public Queue<String> getCode() {
		return code;
	}

	public void replace(Queue<String> morseCode) {
		String element = "";
		while (element != terminator) {
			element = morseCode.remove();
			if (element == "..--..")
				morseCode.add(".-.-.-");
			else
				morseCode.add(element);
		}
	}

	public static void main(String[] args) {
		MorseCode code = new MorseCode();
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(20); i++)
			code.addCode(randomCode());
		code.addCode("..--..");
		code.addCode("..--..");
		for (int i = 0; i < rand.nextInt(20); i++)
			code.addCode(randomCode());
		code.addCode("..--..");
		code.terminateCode();
		System.out.println(code.getCode());
		code.replace(code.getCode());
		System.out.println(code.getCode());

	}
}
