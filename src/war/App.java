package war;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	List<String> familyMembers = List.of("Nick", "Caroline", "Eva", "Loriann", "Ed", "Ann", "Steve", "Doug");
	Random random = new Random();

	public static void main(String[] args) {

		new App().playGame();

	}

	private void playGame() {
		Deck deck = new Deck();
		List<String> familyNames = new LinkedList<>(familyMembers);

		Player player1 = findPlayer(familyNames);
		Player player2 = findPlayer(familyNames);

		System.out.println(player1 + " and " + player2 + " are playing War.");

		shuffledeck(deck);

		dealTheCards(deck, player1, player2);

		playWar(player1, player2);
		findTheWinner(player1, player2);
	}

	private void findTheWinner(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			System.out.println("Player 1: " + player1 + " is the winner with a score of " + player1.getScore());
			System.out.println("Player 2: " + player2 + " is the loser with a score of " + player2.getScore());
		} else if (player2.getScore() > player1.getScore()){
			System.out.println("Player 2: " + player2 + " is the winner with a score of " + player2.getScore());
			System.out.println("Player 1: " + player1 + " is the loser with a score of " + player1.getScore());

		} else {
			System.out.println("There was a Draw, both " + player1 + " and " + player2 + " have a score of " + player1.getScore());
		}
	}

	private void playWar(Player player1, Player player2) {
		int numCards = player1.getHand().size();

		for (int turn = 0; turn < numCards; turn++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();

			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
			} else if (card2.getValue() > card1.getValue()) {
				player2.incrementScore();
			}
		}
	}

	private void dealTheCards(Deck deck, Player player1, Player player2) {
		int deckSize = deck.size();

		for (int i = 0; i < deckSize; i++) {
			if (i % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}

	private void shuffledeck(Deck deck) {
		deck.shuffle();
	}

	private Player findPlayer(List<String> familyMembers) {
		int pos = random.nextInt(familyMembers.size());
		String name = familyMembers.remove(pos);

		return new Player(name);
	}
}
