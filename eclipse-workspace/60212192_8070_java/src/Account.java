
public class Account {
	String name;
	String id;
	Person p;
	int deposit;
	public Account (Person person) {
		p = person;
		this.name = p.name;
		this.id = p.id;
	}
	
	void deposit(int i) {
		this.deposit = i;
		p.deposit = i;
	}
	
	void report() {
		System.out.println("Deposit : " + deposit + " Name : " + name + " id : " + id);
	}
}
