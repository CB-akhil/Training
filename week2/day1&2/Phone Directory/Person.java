package PhoneDirectory;
import java.util.*;
class Person
{
	private String name;
	private String address;
	private ArrayList<PhoneNumber> numbers ;
	
	public void addContact()
	{
		Scanner in = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);
		System.out.print("NAME : ");
		this.name = in.next();
		System.out.print("ADDRESS : ");
		this.address = in.next();

		this.addNumber();
		
	}

	public void addNumber()
	{	char ch1;
		Scanner in = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);
		do
		{
			System.out.print("Phone Number : ");
			double n = inp.nextDouble();
			System.out.print("TYPE - 1.MOBILE 2.HOME 3.WORK : ");
			int ch = inp.nextInt();
			if(numbers == null)
				numbers = new ArrayList<>();
			if(ch == 1)
				numbers.add(new PhoneNumber(n,PhoneNumber.Type.MOBILE));
			else if(ch==2)
				numbers.add(new PhoneNumber(n,PhoneNumber.Type.HOME));
			else
				numbers.add(new PhoneNumber(n,PhoneNumber.Type.WORK));

			System.out.print("ADD ANOTHER NUMBER (Y/N : ");
			ch1 = in.next().charAt(0);
		}while(ch1=='Y' || ch1=='y');
	}

	public String getName()
	{
		return this.name;
	}
	public String getAddress()
	{
		return this.address;
	}

	public ArrayList<Double> getNumbers()
	{
		ArrayList<Double> num = new ArrayList<Double>();
		for(PhoneNumber n : numbers)
		{
			num.add(n.getPhNumber());
		}
		return num;
	}




}