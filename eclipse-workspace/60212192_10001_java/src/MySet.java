
public class MySet extends List {
	public void add(int i) {
		if(!super.includes(i)) {
			super.add(i);
		}
	}
}
