interface BookPrinter {
	public void print(String bookname, String ISBN, String author);
}

class PrettyBookPrinter implements BookPrinter {
	@Override public void print(String bookname, String ISBN, String author) {
		System.out.println("***** Title : " + bookname);
		System.out.println("***** Author : " + author);
		System.out.println("***** ISBN : " + ISBN);
	}
}

class SimpleBookPrinter implements BookPrinter {
	@Override public void print(String bookname, String ISBN, String author) {
		System.out.println(bookname + "/" + author + "/" + ISBN);
	}
}

public class Book {
	private BookPrinter Bp;
	private String bookname, ISBN, author;
	Book(String bookname, String ISBN, String author){
		this.bookname = bookname;
		this.ISBN = ISBN;
		this.author = author;
	}
	public void setPrinter(BookPrinter bp) {
		Bp = bp;
	}
	public void print() {
		Bp.print(bookname, ISBN, author);
	}
}
