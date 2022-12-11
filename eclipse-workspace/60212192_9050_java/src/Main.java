class List{
    public int numElements = 0;
    protected int[] array = new int[10];
    public void addToList(int n){
        array[numElements++] = n;
    } 
    public void show(){
        for (int n=0; n<numElements; n++){
            System.out.println(array[n]);
        }
    }
}

class PositiveList extends List{
	// 양수만 집어 넣는 리스트.
	@Override
    public void addToList(int n){
        if ( n > 0) {
            array[numElements++] = n;
        }
    } 
}

public class Main{
    public static void main(String[] args){
        PositiveList pl = new PositiveList();
        pl.addToList(1);
        pl.addToList(2);
        pl.addToList(-3);
        pl.show();
    }
}