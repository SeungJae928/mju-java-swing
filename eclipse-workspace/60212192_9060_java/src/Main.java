import java.awt.Color;

class Rectangle{
	public String title;
	public Rectangle() {
		
	}
	public Rectangle (String title) {
		this.title = title;
	}
}

class ColoredRectangle extends Rectangle {
	Color color;
	public ColoredRectangle(String title, Color c) {
		color = c;
		this.title = title;
		
	}
	
	void show() {
		System.out.println(color + super.title);
	}
}

public class Main {
	public static void main(String[] args) {
		ColoredRectangle myrect = new ColoredRectangle("평범한 사각형", Color.green);
		myrect.show();
	}

}