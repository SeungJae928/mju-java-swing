public class ObjVector {
    private Object[] ilist;
    private int maxSize;
    private int curSize;
	public ObjVector(int maxSize) {
		this.ilist = new Object[maxSize];
		this.maxSize = maxSize;   // 최대 크기
		this.curSize = 0;  // 현재 크기
	}
	public void add(Object obj) throws Exception {
		if (curSize == maxSize)
			throw new Exception("Vector full");
		ilist[curSize++] = obj;
	}
	public Object get(int i) throws Exception{
		if (i<0 || i>=curSize)
			throw new Exception("invalid index");
		return ilist[i];
	}
	public int size() {
		return curSize;
	}
	public int capacity() {
		return maxSize;
	}
}