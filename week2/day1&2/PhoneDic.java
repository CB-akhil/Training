import java.util.*;
class Person{
	String name,address;
	Person(String name,String add){
		this.name=name;
		address=add;
	}

	@Override
	public boolean equals(Object p1){
		Person person = (Person) p1;
		return (this.name+this.address).contentEquals(person.name+person.address);
	}
	public int hashCode(){
		return (name+address).hashCode();
	}	
}
class Number{
	String number,tag;
	Number(String num,String tag){
		number=num;
		this.tag=tag;
	}
	@Override
	public boolean equals(Object p1){
		Number num = (Number) p1;
		return (this.number).contentEquals(num.number);
	}
	public int hashCode(){
		return (number).hashCode();
	}
}

public class PhoneDic{
	static void add(Person person,Number n){
		if(Directory.contains(person)){
			Set<Number> l = Directory.get(Person);
			l.add(n);
		}else{
			
			person.numbers.add(n,);
			Directory.add(person);
		}
		
	}
	static Map<String,Set<Number>> Directory = new HashMap<>();
	public static void main(String[] args) {
		String[][] sampleData = {
			{"Akhil","perungudi","mobile","9633469511","mobile","1234567890","mobile","2615371937"},
			{"Bobin","chennai","mobile","1234567890","mobile","0987654321","mobile","2415672839"},
		};
		Person p = new Person("Akhil","perungudi");
		Directory.add(p);
		//Directory.add(new Person("Akhil","perungudi"));
		System.out.println(Directory.contains(new Person("Akhil","perungudi")));
		System.out.println(Directory.size());
		//Directory.add(Person.name,Number);
		boolean ch;
		do{
			System.out.print("Enter 1 to search");
			int input=new Scanner.nextInterger();
		}while(ch);

	}
}