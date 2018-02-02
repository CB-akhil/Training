import  java.util.*;
class Employee{
	String name;
	char gender;
	int taxableIncome;
	Employee(String name,char gender,int taxableIncome){
		this.name=name;
		this.gender=gender;
		this.taxableIncome=taxableIncome;
	}
	public char getGender(){
		return gender;
	}
	public int getTaxableIncome(){
		return taxableIncome;
	}
}

public class It{
	private static void calTax(List<Employee> l){
		System.out.println("lsit of Employees:");
		for(Employee element: l){
			int taxAmount;
			if(element.getGender() == 'm'){
				taxAmount= 3 * element.getTaxableIncome()/10;
			}else{
				taxAmount= 2 * element.getTaxableIncome()/10;
			}
			System.out.println(element.name + " " + element.gender + " taxableIncome"+ element.taxableIncome + " taxAmount" + taxAmount);
		}
	}
	public static void main(String[] args) {
		List<Employee> l = new ArrayList<Employee>();
		Employee a = new Employee("Akhil",'m',10000);
		System.out.print(a.name);
		l.add(a);
		a = new Employee("goutham",'m',20000);
		l.add(a);
		a = new Employee("leela",'f',30000);
		l.add(a);
		It.calTax(l);
	}
}