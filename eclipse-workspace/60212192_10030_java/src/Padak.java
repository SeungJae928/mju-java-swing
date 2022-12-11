
public class Padak {
	private KyoChon kyochon;
	public Padak() {
		this.kyochon = new KyoChon();
	}
	public void MakeChicken() throws Exception {
		try {
			kyochon.MakeChicken();
			System.out.println("파를 100그램 얹는다.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
