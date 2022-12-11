class Rectangle <T> {
	private T num1, num2;
	public Rectangle (T n1, T n2){
		num1 = n1;
		num2 = n2;
	}
	@Override public String toString() {
		return ("사각형 밑변 " + num1 + " 높이 " + num2);
	}
}

public class Main {
	public static void main(String[] args) {
	
		Rectangle<Integer> myRectangle = 
                new Rectangle<Integer>(2, 3);
		System.out.println(myRectangle);
		Rectangle<Double> myDoubleRectangle = 
                new Rectangle<Double>(2.5, 3.5);
		System.out.println(myDoubleRectangle);
	}

}
