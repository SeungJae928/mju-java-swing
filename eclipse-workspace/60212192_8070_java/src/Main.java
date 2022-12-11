public class Main{
	public static void main(String[] args){
		Person p1 = new Person("김길동", "941212-1234567");
		Person p2 = new Person("홍길동", "941212-1111111");
		Person p3 = new Person("방승재", "020928-3157618");
		Account a = new Account(p1);
		Account b = new Account(p2);
		Account c = new Account(p2);
		Account d = new Account(p3);
		try{
			a.deposit(1000);
			b.deposit(2000);
			c.deposit(3000);
			d.deposit(5000);
			p1.getAccount(a);
			p2.getAccount(b);
			p2.getAccount(c);
			p3.getAccount(d);
			System.out.println("===============");
			a.report();
			System.out.println("===============");
			b.report();
			System.out.println("===============");
			c.report();
			System.out.println("===============");
			p1.report();
			System.out.println("===============");
			p2.report();
			System.out.println("===============");
			p3.report();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}