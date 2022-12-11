interface Multiplier<E>{
	public E multiply(E a, E b);
}

class Rectangle<E> {
	private E width;
	private E height;
	Rectangle(E width, E height){
		this.height = height;
		this.width = width;
	}
	public String toString() {
		return "사각형 " + width + " X " + height;
	}
	public E area(Multiplier<E> m) {
		return (E) m.multiply(width, height);
	}
}

class IntMultiplier implements Multiplier<Integer> {
	@Override public Integer multiply(Integer a, Integer b) {
		return a*b;
	}
}

class DoubleMultiplier implements Multiplier<Double> {
	@Override public Double multiply(Double a, Double b) {
		return a*b;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle<Integer> myRectangle = new Rectangle<Integer>(2, 3);
		System.out.println(myRectangle);
		System.out.println(myRectangle.area(new IntMultiplier()));
		
		Rectangle<Double> myDoubleRectangle = new Rectangle<Double>(2.5, 3.5);
		System.out.println(myDoubleRectangle);
		System.out.println(myDoubleRectangle.area(new DoubleMultiplier()));
	}

}