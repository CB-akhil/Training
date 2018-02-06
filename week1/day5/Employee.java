import java.util.*;
class Employee {
	String name;
	int salary,age;
	Employee(String name,int age,int salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	public static void main(String[] args) {
		Employee e = new Employee("Akhil",21,15000);
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("goutham",21,16000));
		list.add(e);
		e = new Employee("Bobin",22,15000);
		list.add(e);
		//sorting by name
		Collections.sort(list,(p1,p2)->{  
        return p1.name.compareTo(p2.name);  
        });
        System.out.println("Sorted BY name:"); 
        for(Employee ie:list){
        	System.out.println(ie.name);
        }
        //sorting by Age
        Collections.sort(list,(e1,e2)->{ 
			if(e1.age > e2.age)
				return 1;
			else if (e1.age == e2.age)
				return 0;
			else
				return -1;
		});
        System.out.println("Sorted by Age (low to high)");
		for(Employee ie:list){
        	System.out.println(ie.name);
        }
		//sorting by salary
        Collections.sort(list,(e1,e2)->{ 
			if(e1.salary > e2.salary)
				return 1;
			else if (e1.salary == e2.salary)
				return 0;
			else
				return -1;
		});
        System.out.println("Sorted by salary (low to high)");
		for(Employee ie:list){
        	System.out.println(ie.name);
        }
	}
}