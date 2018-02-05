import java.util.*;

//Exercise 1 animal 


interface character{
	String type();
	boolean canfly();
}
abstract class Animal implements character{
   String name;
   Animal(String name){
   	this.name=name;
   }
   abstract void movement();
}
abstract class Mammal extends Animal{
   Mammal(String input){
   	super(input);
   }
}
abstract class Bird extends Animal{
   Bird(String input){
   	super(input);
   }

}

class Bat extends Bird{
	Bat(){
		super("bat");
	}
    void movement(){
        System.out.println("locomotion is air");
    }
	public String type(){
		return "carnivous";
	}
	public boolean canfly(){
		return true;
	}
}
class Dog extends Mammal{
	Dog(){
		super("Dog");
	}
    void movement(){
        System.out.println("locomotion is Land");
    }
	public String type(){
		return "omnivorus";
	}
	public boolean canfly(){
		return false;
	}
}
class Cow extends Mammal{
	Cow(){
		super("cow");
	}
    void movement(){
        System.out.println("Mode of locomotion is land");
    }
	public String type(){
		return "herbivorous";
	}
	public boolean canfly(){
		return false;
	}
}
class Ostrich extends Bird{
	Ostrich(){
		super("Ostrich");
	}
    void movement(){
        System.out.println("Mode of locomotion is land");
    }
	public String type(){
		return "herbivorous";
	}
	public boolean canfly(){
		return false;
	}
}
class Parrot extends Bird{
	Parrot(){
		super("Parrot");
	}
    void movement(){
        System.out.println("Mode of locomotion is air");
    }
	public String type(){
		return "omnivorus";
	}
	public boolean canfly(){
		return true;
	}
}

public class Main{
    public static void main(String[] args) {
        char choice;
        List<Animal> animals = new ArrayList<Animal>();
        Scanner inp = new Scanner(System.in);
        do{
        int ch;
        System.out.println("1.BAT");
        System.out.println("2.DOG");
        System.out.println("3.COW");
        System.out.println("4.OSTRICH");
        System.out.println("5.PARROT");
        System.out.println("Enter your choice (1-5)");
        ch = inp.nextInt();
        switch(ch)
        {
            case 1:
            {
                Bat b = new Bat();
                animals.add(b);
                break;
            }
            case 2:
            {
                Dog d = new Dog();
                animals.add(d);
                break;
            }
            case 3:
            {
                Cow c = new Cow();
                animals.add(c);
                break;
            }
            case 4:
            {
                Ostrich o = new Ostrich();
                animals.add(o);
                break;
            }
            case 5:
            {
                Parrot p = new Parrot();
                animals.add(p);
                break;
            }
            default:
            {
                System.out.println("WRONG INPUT");
            }
        }
        System.out.println("DO YOU WANT TO ADD ANOTHER SPECIES?(Y/N)");
        choice = inp.next().charAt(0);
        }while(choice=='Y' || choice=='y');
        System.out.println("List of animals added");
        for(Animal a: animals)
            System.out.println(a.name);
        System.out.println("animals That can Fly");
        for(Animal a: animals){
            if(a.canfly())
                System.out.println(a.name);
            }
        System.out.println("Animal that are herbivorous:");
        for(Animal a:animals){
            if(a.type()=="herbivorous")
                System.out.println(a.name);
        }
	}
}

