import java.util.Scanner;
class Animal{
	String name;
	void Animal(String temp){
		name=temp;
	}
	String getAnimal(){
		return name;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("enter animal Name:");
			String input=scanner.next();
			Animal animals[]= new Animal(input);
			System.out.println("entered Animals");
			for(int i=0;i<animals.length;i++){
				System.out.println(animals[i].getAnimal());
			}
			System.out.println("enter 1 to input another animal");
			int ch=scanner.nextInt();
		}while(ch==1);
		String input;
	}
}