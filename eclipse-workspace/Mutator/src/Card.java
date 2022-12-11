public class Card {
	public static final String[] suitname = { "♠", "♥", "◆", "♣" };
	public static final String[] rankname = {"A", "2", "3", "4", "5", "6", "7", "8", 
		"9", "10", "J", "Q", "K" };
	public void draw(){
		System.out.println(suitname[suit] + rankname[rank]);
	}
	public int suit, rank;
	
	public void setRank(int i) throws Exception {
		if (i < 0 || i> 12){
		    throw (new Exception("Rank오류"));
		}

		this.rank = i;
	}
	public void setSuit(int i) throws Exception {
		if(i < 0 || i >3) {
		    throw (new Exception("Suit오류"));
		}

		this.suit = i;
		}
}
