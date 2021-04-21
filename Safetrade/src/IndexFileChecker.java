
/**
 * IndexFileChecker: a program that checks whether the index of a book has all lines in the same indented block
 * in alphabetical order.
 * 
 * Author: Michael Huang
 * Course: CSC630, Ms. Litvin
 * Due: 2020-03-06
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class IndexFileChecker {
	/**
	 * Recursively checks whether the book indices are in alphabetical order.
	 * 
	 * @param startLineNum is the line number at which the checking starts
	 * @return the number of the last line traversed if the book indices are in
	 *         alphabetical order and -1 if the book indices are not in alphabetical
	 *         order.
	 */
	public int checkIndented(ArrayList<StringBuffer> text, int startLineNum) {
		int indents = indentNum(text.get(startLineNum));
		int lineNum;
		String previousLine = null;

		for (lineNum = startLineNum; lineNum < text.size(); lineNum++) {
			int temp = indentNum(text.get(lineNum));

			if (indents != temp && temp >= 0) {
				if (lineNum >= text.size() || temp < indents)
					break;
				else {
					lineNum = checkIndented(text, lineNum);
					if (lineNum == -1) // -1 is false
						return -1;
					if (lineNum >= text.size())
						break;
				}
			} else if (temp == -1)
				continue;

			String newString = text.get(lineNum).substring(indents, text.get(lineNum).length());
			if (previousLine != null && newString.compareTo(previousLine) < 0) {
				return -1;
			}
			previousLine = newString;
		}
		return lineNum;
	}

	/**
	 * Recursively sorts all indented blocks of lines using radix sort.
	 * 
	 * @param text must be in lower case
	 * @param startLineNum indicates the lineNumber at which the sorting starts
	 * @return the number of the last line traversed
	 */
	public int sortIndented(ArrayList<StringBuffer> text, int startLineNum) {
		int indents = indentNum(text.get(startLineNum));
		boolean result = true;
		int lineNum;
		LinkedList<String> lines = new LinkedList<String>();
		ArrayList<Integer> linesTraversed = new ArrayList<Integer>();

		for (lineNum = startLineNum; lineNum < text.size();) {
			int temp = indentNum(text.get(lineNum));

			if (indents != temp && temp >= 0) {
				if (lineNum >= text.size() || temp < indents)
					break;
				else {
					lineNum = sortIndented(text, lineNum);
					continue;
				}
			}

			if (temp == -1) { // an empty line
				linesTraversed.add(lineNum);
				lineNum++;
				continue;
			}

			linesTraversed.add(lineNum);
			String newString = text.get(lineNum).substring(indents, text.get(lineNum).length());
			result = result && (lines.isEmpty() || newString.compareTo(lines.getLast()) > 0);
			lines.addLast(newString);
			lineNum++;
		}

		if (!result)
			sortLines(text, lines, linesTraversed, getBlanks(indents));
		return lineNum;
	}

	/*
	 * sorts the indented lines into alphabetical order
	 */
	private void sortLines(ArrayList<StringBuffer> text, LinkedList<String> lines, ArrayList<Integer> linesTraversed,
			String blanks) {
		lines = RadixSort.sort(lines);
		Iterator<String> iter = lines.iterator();
		for (int i : linesTraversed) {
			if (indentNum(text.get(i)) == -1)
				continue;
			text.set(i, new StringBuffer(blanks + "" + iter.next()));
		}
	}

	/*
	 * returns an indicated number of indentations.
	 */
	private String getBlanks(int num) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < num; i++)
			result.append('	');
		return result.toString();
	}

	/*
	 * Measures the number of indents in a line before the letters start. text is
	 * the line of String measured. return the number of indentations if there are
	 * letters in the line, if not, return -1.
	 */
	private int indentNum(StringBuffer text) {
		for (int i = 0; i < text.length(); i++)
			if (Character.isAlphabetic(text.charAt(i)))
				return i;
		return -1;
	}

	/*
	 * Created for demonstration purposes.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(
				new FileReader("/Users/michaelhyh/Project Data/Eclipse Java/BookIndex/src/bookindex2.txt"));
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
		IndexFileChecker checker = new IndexFileChecker();
		int endIndex = checker.checkIndented(text, 0);
		if (endIndex == -1) {
			System.out.println("False, the book index is not in alphabetical order!\nModified book index:\n");
			checker.sortIndented(text, 0);
		} else
			System.out.println("True, the book index is in alphabetical order.\nOriginal book index:\n");

		for (StringBuffer buf : text)
			System.out.println(buf);

		input.close();
	}
}
