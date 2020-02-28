import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class indexFileChecker {
	/**
	 * This is a private helper method which measures the number of indents in a line before letters start.
	 * @param text is the line of String measured
	 * @return the number of indent if there are letters in the line, if not, return -1.
	 */
	private int indentNum(StringBuffer text) {
		for (int i = 0; i < text.length(); i++)
			if (Character.isAlphabetic(text.charAt(i)))
				return i;
		return -1;
	}

	/**
	 * This method recursively checks whether the indented text is in alphabetical
	 * order. If not the indented lines not in alphabetical order will be sorted
	 * using radix sort.
	 * 
	 * @param text must be in lower case.
	 * @param startLineNum is the line number at which the checking starts
	 * @return true if the text is in alphabetical order and false otherwise.
	 */
	public boolean checkIndented(ArrayList<StringBuffer> text, int startLineNum) {
		int indents = indentNum(text.get(startLineNum));
		boolean result = true;
		int lineNum;
		LinkedList<String> lines = new LinkedList<String>();
		for (lineNum = startLineNum; lineNum < text.size(); lineNum++) {
			int temp = indentNum(text.get(lineNum));
			if (indents != temp && temp >= 0)
				break;
			if (temp == -1)
				continue;
			String newString = text.get(lineNum).substring(indents, text.get(lineNum).length());
			result = result && (lines.isEmpty() || newString.compareTo(lines.getLast()) > 0);
			lines.addLast(newString);
		}
		if (!result) {
			RadixSort.sort(lines);
			Iterator<String> iter = lines.iterator();
			for (int i = startLineNum; i < lineNum; i++)
				text.set(i, new StringBuffer(getBlanks(indents) + "" + iter.next()));
		}
		if (lineNum >= text.size() || indentNum(text.get(lineNum)) <= indents)
			return result;
		else
			return result && checkIndented(text, lineNum);
	}

	/**
	 * This is a private helper method that returns an indicated number of indents.
	 * @param num
	 * @return
	 */
	private String getBlanks(int num) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < num; i++)
			result.append('	');
		return result.toString();
	}

	/**
	 * This method is created for demonstration purposes.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(
				new FileReader("/Users/michaelhyh/Project Data/Eclipse Java/BookIndex/src/bookindex.txt"));
		ArrayList<StringBuffer> text = new ArrayList<StringBuffer>();
		StringBuffer line;
		while (true) {
			try {
				line = new StringBuffer(input.readLine());
			} catch (Exception e) {
				break;
			}
			text.add(line);
		}
		indexFileChecker checker=new indexFileChecker();
		System.out.println(checker.checkIndented(text, 0));
		for (StringBuffer buf : text)
			System.out.println(buf);

		input.close();
	}
}
