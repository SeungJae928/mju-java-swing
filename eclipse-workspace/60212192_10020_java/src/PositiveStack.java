
public class PositiveStack extends Stack {
	public void push(int i) {
		if(i > 0) {
			super.push(i);
		}
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}
	public void pop() {
		super.pop();
	}
	public int top() {
		return super.top();
	}
}
