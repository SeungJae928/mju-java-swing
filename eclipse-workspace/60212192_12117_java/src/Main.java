public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("Java Book", "111-22-333333", "Jane Austin");
		System.out.println("첫번째 출력:");
		b1.setPrinter(new SimpleBookPrinter());
		b1.print();
		System.out.println("두번째 출력:");
		b1.setPrinter(new PrettyBookPrinter());
		b1.print();
	}

}