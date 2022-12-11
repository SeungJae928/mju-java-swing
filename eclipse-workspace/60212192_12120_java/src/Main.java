interface Comparer{
	public boolean compare(Player p1, Player p2);
	public String PlayerData(Player p);
}

class NameComparer implements Comparer{
	@Override public boolean compare(Player p1, Player p2) {
		if (p1.name.compareTo(p2.name) > 0) {
			return true;
		}
		else if(p1.name.compareTo(p2.name) < 0) {
			return false;
		} 
		else {
			return false;
		}
	}
	@Override public String PlayerData(Player p) {
		return p.name + " 나이: " + String.valueOf(p.age) + " 타율: " + String.valueOf(p.average);
	}
}

class AgeComparer implements Comparer{
	@Override public boolean compare(Player p1, Player p2) {
		return p1.age < p2.age;
	}
	@Override public String PlayerData(Player p) {
		return p.name + " 나이: " + String.valueOf(p.age) + " 타율: " + String.valueOf(p.average);
	}
}

class AverageComparer implements Comparer{
	@Override public boolean compare(Player p1, Player p2) {
		return p1.average < p2.average;
	}
	@Override public String PlayerData(Player p) {
		return p.name + " 나이: " + String.valueOf(p.age) + " 타율: " + String.valueOf(p.average);
		}
}

class ReverseAverageComparer implements Comparer{
	@Override public boolean compare(Player p1, Player p2) {
		return p1.average > p2.average;
	}
	@Override public String PlayerData(Player p) {
		return p.name + " 나이: " + String.valueOf(p.age) + " 타율: " + String.valueOf(p.average);
	}
}

class Team {
	private int index = 0;
	private Player[] Players;
	public Team(int num) {
		Players = new Player[num];
	}
	public void add(Player P) {
		Players[index++] = P;
	}
	public String getBest(Comparer cp) {
		int player_index = 0;
		Player player = Players[0];
		for(int i = 0; i < Players.length; i++) {
			if(cp.compare(player, Players[i])) {
				player_index = i;
				player = Players[i];
			}
			if(Players[i + 1] == null) {
				break;
			}
		}
		return cp.PlayerData(Players[player_index]);
	}
}

class Player {
	public String name;
	public int age;
	public double average;
	Player(String name, int age, double average){
		this.age = age;
		this.average = average;
		this.name = name;
	}
}

public class Main{
	public static void main(String[] args){
		Team myTeam = new Team(20);  // 최대 20명
		myTeam.add(new Player("홍길동", 25, 0.25));
		myTeam.add(new Player("조길동", 35, 0.2));
		myTeam.add(new Player("정길동", 22, 0.33));
		myTeam.add(new Player("박길동", 27, 0.30));
		myTeam.add(new Player("김길동", 24, 0.35));
		
		System.out.println("이름이 가장 빠른 사람:" 
		    + myTeam.getBest(new NameComparer()));
        System.out.println("나이가 가장 많은 사람:" 
		    + myTeam.getBest(new AgeComparer()));
		System.out.println("타율이 가장 높은 사람:" 
		    + myTeam.getBest(new AverageComparer()));
		System.out.println("타율이 가장 낮은 사람:" 
		    + myTeam.getBest(new ReverseAverageComparer()));
	}
}