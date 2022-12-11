
public class Padak extends KyoChon {
	public void MakeChicken() {
		try {
			super.MakeChicken();
			System.out.println("파를 100그램 얹는다.");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
