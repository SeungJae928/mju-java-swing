public class Person{
	public String name;
	public String id;  // 주민번호
	Account[] acc = new Account[10];// 최대 10개의 계좌 정보를 가지도록 한다.
	int deposit;
	int i = 0;
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void report(){
		System.out.println("Name : " + name + " " + id);
		System.out.println("Account:");
		for(int index = 0; index < i; index++) {
			System.out.println("Name : " + name + " " + id + " deposit " + acc[index].deposit);
		}
		// 이 사람이 가지고 있는 모든 계좌의 정보를 출력한다.
	}
	
	void getAccount(Account a) {
		acc[i] = a;
		i++;
	}
}
