interface PlayerComparer{
	boolean compare(Player one, Player two);
}

class AverageComparer implements PlayerComparer {
	@Override public boolean compare(Player one, Player two) {
		return one.average > two.average;
	}
}

class NameComparer implements PlayerComparer {
	@Override public boolean compare(Player one, Player two) {
		return false;
	}
}

class Player{
	public String name;
	public double average;
	public Player(String name, double average) {
		super();
		this.name = name;
		this.average = average;
	}
}


public class Sorter {
	public Player[] myPlayers;
	public Sorter() {
		myPlayers = new Player[5];
		myPlayers[0] = new Player("김길동", 0.3);
		myPlayers[1] = new Player("이길동", 0.1);
		myPlayers[2] = new Player("박길동", 0.23);
		myPlayers[3] = new Player("방길동", 0.32);
		myPlayers[4] = new Player("조길동", 0.15);
	}
	public Player findMax(PlayerComparer pc) {
		int maxp = 0;
		Player p = myPlayers[0];
		double maxav = myPlayers[0].average;
		for(int i = 0; i < 5; i++) {
			if(pc.compare(p, myPlayers[i])) {
				p = myPlayers[i];
				maxp = i;
			}
		}
		return myPlayers[maxp];
	}
	public static void main(String[] args) {
		Sorter s = new Sorter();
		System.out.println(s.findMax(new AverageComparer()));
	}
}
