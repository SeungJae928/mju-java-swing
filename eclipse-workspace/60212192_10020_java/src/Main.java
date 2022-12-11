public class Main {
	public static void main(String[] args){
		//
		PositiveStack st = new PositiveStack();
		st.push(11);
		st.push(22);
		st.push(-33);
		st.push(33);
		while (!st.isEmpty()){
			System.out.println(st.top()); 
			st.pop();
		}
	}
}