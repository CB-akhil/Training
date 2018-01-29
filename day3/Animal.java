import java.util.Scanner;
class Animal{
	String name;
	public static int number=0;
	Animal(String input){
		name=input;
		number++;
	}
	String getAnimal(){
		return name;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ch;
		do{
			System.out.println("enter animal Name:");
			String input=scanner.next();
			Animal animals= new Animal(input);
			System.out.println("number of animals:"+animals.number);
			System.out.println("enter 1 to input another animal");
			ch=scanner.nextInt();
		}while(ch == 1);
		String input;
	}
}