 abstract class Figure {
    protected double height, width;
    abstract double area();
    abstract void draw();
    public void reSize(double h, double w){
        height = h;
        width = w;
    }
}

class Triangle extends Figure{
	@Override public double area(){
        return height * width / 2;
    }
    @Override public void draw(){
        System.out.println("나는 삼각형입니다.");
        System.out.println("높이는 " + height + 
               " 폭은 " + width + "입니다.");
    }
}

class Rectangle extends Figure{
	@Override public double area() {
		return height * width;
	}
	@Override public void draw() {
		System.out.println("나는 사각형입니다.");
        System.out.println("높이는 " + height + 
               " 폭은 " + width + "입니다.");
	}
}

public class TriangleApp {
    public static void main(String[] args){
    	Figure fig[] = new Figure[2];
        fig[0] = new Triangle();
        fig[1] = new Rectangle();
        fig[0].reSize(3.0, 3.0);  
        fig[1].reSize(3.0, 3.0);  
        
        for (Figure f: fig){
        	f.draw();	
        	System.out.println("면적: " + f.area());
        }
       
    }

}
