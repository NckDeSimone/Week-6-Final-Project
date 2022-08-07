package war;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

	List<String> cardNames = List.of("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
			"Queen", "King", "Ace");
	List<String> suits = List.of("Diamonds", "Clubs", "Hearts", "Spades");
	List<Card> cards = new LinkedList<>();

	public Deck() {
		for (int i = 0; i < cardNames.size(); i++) {
			String cardName = cardNames.get(i);
			int value = i + 2;

			for (String suit : suits) {
				cards.add(new Card(cardName, suit, value));
			}
		}
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("\nCards in deck:\n");
		for (Card card : cards) {
			b.append(card).append("\n");
		}
		return b.toString();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void shuffle() {
		Random random = new Random();
		List<Card> tempCards = new LinkedList<>(cards);

		cards.clear();

		while (!tempCards.isEmpty()) {
			int pos = random.nextInt(tempCards.size());
			cards.add(tempCards.remove(pos));
		}
	}

	public int size() {
		return cards.size();
	}

}
