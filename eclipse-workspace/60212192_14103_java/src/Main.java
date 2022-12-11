import java.util.HashMap;
import java.util.Map;

class MyMap<K, V>{
	private Object[] keyArray = new Object[10000];
	private Object[] valueArray = new Object[10000];
	private Integer index = 0;
	private Integer size = 0;
	public void put(K key, V value) {
		if(index < 10000) {
			valueArray[index] = value;
			keyArray[index] = key;
			index += 2;
			size++;
		}
	}
	public String get(K key) {
		int index_num = getindex(key);
		if(index_num == -1) {
			return null;
		} 
		else {
			String value = (String) valueArray[index_num];
			return value;
		}
	}
	public int getindex(K key) {
		for(int i = 0; i< keyArray.length; i++) {
			if(keyArray[i] == null) {
				continue;
			}
			else if(keyArray[i].equals((Integer) key)) {
				return i;
			} 
		}
		return -1;
	}
	public int size() {
		return size;
	}
}

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCorrect = 0;
		long t0 = System.currentTimeMillis();
		Map<Integer, String> goodMap = new HashMap<>();
		for (int i=0; i<10000; i+= 2) {
			goodMap.put(i, "Value"+i);
		}
		for (int i=0; i<9999; i++) {
			int k = (int)(Math.random() * 10000);
			String val = goodMap.get(k);
			if (k%2 == 0 && val!=null || k%2 !=0 && val==null) {
				numCorrect++;
			} 
		}
		System.out.println("Hashmap:\n정확한 회수: " + numCorrect);
		System.out.println("저장된 쌍의 수: " + goodMap.size());
		long t1 = System.currentTimeMillis();
		
		System.out.println("소요시간(ms) = " + (t1-t0));
		
		numCorrect = 0;
		long t2 = System.currentTimeMillis();
		MyMap<Integer, String> badMap = new MyMap<>();
		for (int i=0; i<10000; i+= 2) {
			badMap.put(i, "Value"+i);
		}
		for (int i=0; i<9999; i++) {
			int k = (int)(Math.random() * 10000);
			String val = badMap.get(k);
			if (k%2 == 0 && val!=null || k%2 !=0 && val==null) {
				numCorrect++;
			} else {
				System.out.println("Incorrect " + k + "/" + val);
			}
		}
		System.out.println("\nMyMap:\n정확한 회수: " + numCorrect);
		System.out.println("저장된 쌍의 수: " + badMap.size());
		long t3 = System.currentTimeMillis();
		
		System.out.println("소요시간(ms) = " + (t3-t2));
	
	}

}
