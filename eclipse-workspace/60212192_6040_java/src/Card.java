class Card {
	private int num = 0;
	private static String str;
	private String suit;

	public Card() {

	}

	public Card(String s, int rank) {
		String num = "";
		suit(rank);
		s = suit;
		if (rank > 13) {
			rank = rank%13;
		}
		if (rank%13 == 1) {
			char rank_;
			rank = 'A';
			rank_ = (char) rank;
			num = String.valueOf(rank_);
		}
		else if (rank%13 == 11) {
			char rank_;
			rank = 'J';
			rank_ = (char) rank;
			num = String.valueOf(rank_);
		}
		else if (rank%13 == 12) {
			char rank_;
			rank = 'Q';
			rank_ = (char) rank;
			num = String.valueOf(rank_);
		} 
		else if (rank%13 == 0) {
			char rank_;
			rank = 'K';
			rank_ = (char) rank;
			num = String.valueOf(rank_);
		}
		else {
			num = String.valueOf(rank);
		}
		str = s + num;
	}
	public String suit(int i) {
		if ((i-1)/13 == 0) {
			suit = "♠";
		}
		else if ((i-1)/13 == 1) {
			suit = "♣";
		}
		else if ((i-1)/13 == 2) {
			suit = "♥";
		}
		else if ((i-1)/13 == 3) {
			suit = "◆";
		}
		return suit;
	}

	public String toString() {
		return str;
	}
	public void show() {
		System.out.println(str);
	}
}