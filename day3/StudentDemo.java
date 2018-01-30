class Student{
	int studentdId;
	String studentName;
	boolean gender;
	Subject subjects;
	void setId(int temp){
		studentdId=temp;
	}
	int getId(){
		return studentdId;
	}
	void setName(String temp){
		studentName=temp;
	}
	int getName(){
		return studentName;
	}
	void setGender(boolean temp){
		gender=temp;
	}
	boolean getGender(){
		return gender
	}
	void setSubjects(Subject temp){
		subjects=temp;
	}
	Subject getSubject(){
		return subjects;
	}
}
class subjects{
	String sub1,sub2,sub3;
	int m1,m2,m3;
	void setSub1(String temp){
		sub1=temp;
	}
	String getSub1(){
		return sub1;
	}
	void setSub2(String temp){
		sub2=temp;
	}
	String getSub2(){
		return sub2;
	}
	void setSub3(String temp){
		sub3=temp;
	}
	String getSub3(){
		return sub3;
	}
}
class RestultGenerator{
	static generateResult(Student input){
		System.out.println(" Report Card  ");
		System.out.println("subject 1: " + input.sub1);
		System.out.println("marks"+m1);
		System.out.println("subject 2: " + input.sub2);
		System.out.println("marks"+m2);
		System.out.println("subject 3: " + input.sub3);
		System.out.println("marks"+m3);
		System.out.println("Total :" + m1+m2+m3);
		System.out.println("Average : " + (float)(m1+m2+m3)/3);
	}
}
public class StudentDemo{
	Student s1;
	void storeStudentData(Student temp){
		s1=temp;
	}
	public static void main(String[] args) {
		String input;
		Scanner scanner=new Scanner();
		Student student=new Student();
		System.out.println("Enter Sudent name:");
		input=scanner.next();
		student.setName(input);
		boolean bool;
		System.out.println("enter Student gender ");
		bool=scanner.nextBoolean();


	}
}