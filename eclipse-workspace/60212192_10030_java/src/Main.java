public class Main {
	public static void main(String[] args){
		Padak k = new Padak();
		try {
			k.MakeChicken();
		} catch (Exception e){
			System.out.println("Cannot make chicken");
		}
	}
}
