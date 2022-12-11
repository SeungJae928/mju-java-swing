abstract class Rectangle<E>{
	protected E width;
	protected E height;
	public Rectangle(E width, E height) {}
	public E getWidth() {return null;}
	public E getHeight() {return null;}
	public String toString() {return null;}
	public E area() {return null;}
}
	
class IntRectangle extends Rectangle<Integer> {
	public IntRectangle(Integer width, Integer height) {
		super(width, height);
		super.width = width;
		super.height = height;
	}
	@Override public Integer getWidth() {
		return super.width;
	}
	@Override public Integer getHeight() {
		return super.height;
	}
	@Override public Integer area() {
		return getHeight() * getWidth();
	}
	@Override public String toString() {
		return "사각형 " + width + " X " + height;
	}
}

class DblRectangle extends Rectangle<Double> {
	public DblRectangle(Double width, Double height) {
		super(width, height);
		super.width = width;
		super.height = height;
	}
	@Override public Double getWidth() {
		return super.width;
	}
	@Override public Double getHeight() {
		return super.height;
	}
	@Override public Double area() {
		return getHeight() * getWidth();
	}
	@Override public String toString() {
		return "사각형 " + width + " X " + height;
	}
}
// IntRectangle은 Rectangle을 추상 클래스로 한 뒤 상속을 받는다.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntRectangle myRectangle = new IntRectangle(2, 3);
		System.out.println(myRectangle);
		System.out.println("면적: " + myRectangle.area());
		
		DblRectangle myDoubleRectangle = new DblRectangle(2.5, 3.5);
		System.out.println(myDoubleRectangle);
		System.out.println("면적: " + myDoubleRectangle.area());
	}

}