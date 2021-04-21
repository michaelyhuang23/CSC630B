
import java.util.Stack;

/**
 * This project is created for exercise 5 of chapter 22 of Java Methods
 * @author michaelhyh
 *
 */

/**
 * This class is created for testing purposes.
 */
class Card {
	private int numb;

	public Card(int n) {
		numb = n;
	}

	public String toString() {
		return Integer.toString(numb);
	}
}

public class CardMover {
	/**
	 * satisfy the requirement as lay out by Java Methods exercise 5 of chapter 22
	 */
	public boolean moveToTop(Stack<Card> deck, int n) {
		if (n > deck.size())
			return false;
		Stack<Card> newDeck = new Stack<Card>();
		Card desiredCard = null;
		int i = 0;
		while (!deck.isEmpty()) {
			i++;
			if (i == n)
				desiredCard = deck.pop();
			else
				newDeck.push(deck.pop());
		}
		while (!newDeck.isEmpty())
			deck.push(newDeck.pop());
		deck.push(desiredCard);
		return true;

	}

}
