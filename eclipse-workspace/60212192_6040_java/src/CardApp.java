

public class CardApp {

	public static void main(String[] args) {
		String suit = "";
		Card[] myCard = new Card[52];
		for (int i = 0; i < 52; i++) {
			myCard[i] = new Card(suit, i+1);
			myCard[i].show();
		}
	}

}
