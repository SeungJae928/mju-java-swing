class MyVector <T> {
	private Object[] obj;
	private int index = 0;
	public MyVector(int num) {
		obj = new Object[100];
	}
	public void insert(T num) {
		obj[index++]  = num;
	}
	public T get(int num) {
		return (T) obj[num];
	}
	public int size() {
		int index_size = 0;
		while(obj[index_size] != null) {
			index_size++;
		}
		return index_size;
	}
}

public class Main{
    public static void main(String[] args){
        MyVector<Integer> v = new MyVector<Integer>(100);   // 100개짜리로 한다.
        v.insert(11);
        v.insert(22);
        v.insert(33);
        for (int i=0; i<v.size(); i++){
            System.out.println(v.get(i));
        }
    }
}