import java.util.Scanner;

public class Main {
	Army[] myArmy = new Army[20];
	int numArmy = 0;
	public void run() {
		myArmy[numArmy++] = new Tank(10,10);
		myArmy[numArmy++] = new Tank(20,20);
		myArmy[numArmy++] = new Soldier(5, 5);
		myArmy[numArmy++] = new Soldier(3, 3);
		
		Scanner s = new Scanner(System.in);
		while (s.hasNextInt()) {
			int x = s.nextInt();
			if (s.hasNext()) {
				int y = s.nextInt();
				for (int i=0; i<numArmy; i++){
					if (myArmy[i].areYouThere(x, y))
						myArmy[i].damage(10);
				}
			} else break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.run();
	}

}
