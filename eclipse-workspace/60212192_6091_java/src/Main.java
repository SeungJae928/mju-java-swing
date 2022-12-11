import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		MyStringArray myArray = new MyStringArray(5);  // 크기 5. 중간에 늘리는 것은 없다.
		Scanner myScan = new Scanner(System.in);
		
		try {
			while (myScan.hasNext()){
				myArray.add(myScan.next()); // 스트링이 순서대로 삽입된다.
				System.out.println(myArray.size());  // 현재의 개수를 출력한다.
			}
		} catch ( Exception e) {
			// add 가 실패할 경우 여기서 처리
			System.out.println(e.getMessage());
		}
				
		try {
			for (int i=myArray.size()-1; i>=0; i--){  // size 함수는 실제 내용물 개수를 반환한다.
				System.out.println(myArray.elementAt(i));  // i 번째 요소를 돌려준다.
			}
			System.out.println(myArray.elementAt(myArray.size()));  // 없는 배열을 액세스.
		} catch ( Exception e ){
			System.out.println(e.getMessage());
		}

	}
}