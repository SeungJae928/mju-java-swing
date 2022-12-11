class Figure{
    public void show(){
        System.out.println("Figure 입니다.");
    }
}
class Rect extends Figure{
    @Override public void show(){
        System.out.println("사각형 입니다.");
    }
}
class Oval extends Figure{
    @Override public void show(){
        System.out.println("타원형 입니다.");
    }
}

class FigVector {
	private Object[] figures;
	private int index = 0;
	public FigVector() {
		figures = new Object[20];
	}
	public void add(Figure fig) {
		figures[index++] = fig;
	}
	public void show() {
		for(int i = 0; i < index; i++) {
			((Figure) figures[i]).show();
		}
	}
}
public class Main{
	public static void main(String[] args){
		FigVector fv = new FigVector();
		fv.add(new Rect());
		fv.add(new Rect());
		fv.add(new Oval());
		fv.add(new Oval());
		fv.show();
	}
}
