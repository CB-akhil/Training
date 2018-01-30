import java.util.Scanner;
class Subject{
	String sub1,sub2,sub3;
	int m1,m2,m3;
	public void setSub1(String temp){
		sub1=temp;
	}
	public String getSub1(){
		return sub1;
	}
	public void setSub2(String temp){
		sub2=temp;
	}
	public String getSub2(){
		return sub2;
	}
	public void setSub3(String temp){
		sub3=temp;
	}
	public String getSub3(){
		return sub3;
	}
	public void setm1(int temp){
		m1=temp;
	}
	public int getm1(){
		return m1;
	}
	public void setm2(int temp){
		m2=temp;
	}
	public int getm2(){
		return m2;
	}
	public void setm3(int temp){
		m3=temp;
	}
	public int getm3(){
		return m3;
	}
}
class Student{
	int studentdId;
	String studentName;
	boolean gender;
	public Subject subjects;
	public void setId(int temp){
		studentdId=temp;
	}
	public int getId(){
		return studentdId;
	}
	public void setName(String temp){
		studentName=temp;
	}
	public String getName(){
		return studentName;
	}
	public void setGender(boolean temp){
		gender=temp;
	}
	public boolean getGender(){
		return gender;
	}
	public void setSubjects(Subject temp){
		subjects=temp;
	}
	/*Subject getSubject(){
		return subjects;
	}*/
}
class RestultGenerator{
	static void generateResult(Student input){
		System.out.println(" Report Card  ");
		System.out.println("subject 1: " + input.subjects.getSub1());
		System.out.println("marks"+input.subjects.getm1());
		System.out.println("subject 2: " + input.subjects.getSub2());
		System.out.println("marks"+input.subjects.getm2());
		System.out.println("subject 3: " + input.subjects.getSub3());
		System.out.println("marks"+input.subjects.getm3());
		System.out.println("Total :" + input.subjects.getm1()+input.subjects.getm2()+input.subjects.getm3());
		System.out.println("Average : " + (float)(input.subjects.getm1()+input.subjects.getm2()+input.subjects.getm3())/3);
	}
}
public class StudentDemo{
	Student s1;
	void storeStudentData(Student temp){
		s1=temp;
	}
	public static void main(String[] args) {
		String input;
		Scanner scanner=new Scanner(System.in);
		Student student=new Student();
		System.out.println("Enter Sudent Id:");
		int num=scanner.nextInt();
		student.setId(num);
		System.out.println("Enter Sudent name:");
		input=scanner.next();
		student.setName(input);
		boolean bool;
		System.out.println("enter Student gender ");
		bool=scanner.nextBoolean();
		Subject subject=new Subject();
		System.out.println("Enter Subject1 name:");
		input=scanner.next();
		subject.setSub1(input);
		System.out.println("Enter Subject1 marks:");
		num=scanner.nextInt();
		subject.setm1(num);
		System.out.println("Enter Subject2 name:");
		input=scanner.next();
		subject.setSub2(input);
		System.out.println("Enter Subject2 marks:");
		num=scanner.nextInt();
		subject.setm2(num);
		System.out.println("Enter Subject3 name:");
		input=scanner.next();
		subject.setSub3(input);
		System.out.println("Enter Subject3 marks:");
		num=scanner.nextInt();
		subject.setm3(num);
		student.setSubjects(subject);
	}
}