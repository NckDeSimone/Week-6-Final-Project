package war;

public class Card {

	private String name;
	private String suit;
	private int value;

	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}

	public String toString() {
		return name + " of " + suit + ", Value = " + value;
	}

	public int getValue() {
		return value;
	}

}
