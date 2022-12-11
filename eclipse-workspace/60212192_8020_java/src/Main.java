class DogSchool {
	Dog[] dg = new Dog[100];
	String name;
	String dog_breed;
	String SchoolName;
	static int index = 0;
	public DogSchool (String s) {
		this.SchoolName = s;
	}
	void register(Dog d) {
		dg[index] = d;
		this.name = dg[index].name;
		this.dog_breed = dg[index].dog_breed;
		index++;
	}
	public String getName() {
		return name;
	}
	public String getDog_breed() {
		return dog_breed;
	}
	void speak() {
		System.out.println("여기는 " + SchoolName + " 학생은:");
		for(int i = 0; i < index; i++) {
			if(dg[i].SchoolName == null) {
				System.out.println(dg[i].name + " " + dg[i].dog_breed + " 소속된 학교가 없습니다.");
			}
			else {
				System.out.println(dg[i].name + " " + dg[i].dog_breed + " 소속학교는 " + dg[i].SchoolName);
			}
		}
		System.out.println();
	}
}

class Dog {
	DogSchool ds;
	String name;
	String dog_breed;
	String SchoolName;
	public Dog (String name, String s) {
		this.name = name;
		this.dog_breed = s;
	}
	void speak() {
		if(SchoolName == null) {
			System.out.println(name + " " + dog_breed + " 소속된 학교가 없습니다.");
		}
		else {
			System.out.println(name + " " + dog_breed + " 소속학교는 " + ds.SchoolName);
		}
		System.out.println();
	}
	void rename(String s) {
		this.name = s;
	}
	void getSchoolName(DogSchool d) {
		ds = d;
		this.SchoolName = ds.SchoolName; 
	}
	public String getName() {
		return name;
	}
}

public class Main{
    public static void main(String[] args){
        DogSchool ds = new DogSchool("MJ 애견학교" );
        Dog d1 = new Dog("뚱이", "불독");
        Dog d2 = new Dog("철이", "푸들");
        Dog d3 = new Dog("순이", "푸들");
        ds.register(d1);
        ds.register(d2);
        ds.register(d3);
        
        d1.getSchoolName(ds);
        d2.getSchoolName(ds);
        d3.getSchoolName(ds);
        
        d1.speak();
        ds.speak();
        d1.rename("띵이");
        ds.speak();
    }
}