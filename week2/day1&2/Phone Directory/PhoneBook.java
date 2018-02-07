package PhoneDirectory;
import java.util.*;
class PhoneBook
{

	static Map<String,List<Person>> phonebook = new HashMap<String,List<Person>>();

	public static void display(List<Person> p)
	{

		for(Person per : p)
			{
				System.out.println("\n"+per.getName());
				System.out.println(per.getAddress());
				for(Double d: per.getNumbers())
				System.out.printf("%.0f\n",d);
			}
	}

	public static void SearchNum(List<Person> p , double num)
	{
		for(Person per: p)
		{
			for(Double d: per.getNumbers())
			{
				if(d == num)
					System.out.println(per.getName());
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);
		int ch ;
	do
	{	
		System.out.println("\n1.ADD CONTACT");
		System.out.println("2.SEARCH CONTACT BY NAME");
		System.out.println("3.SEARCH CONTACT BY NUMBER");
		System.out.println("4.EXIT");

		System.out.println("\n Enter Your CHoice : ");
		ch = inp.nextInt();
		switch(ch)
		{
			case 1:
			{
				Person p = new Person();
				p.addContact();

				if(phonebook.get(p.getName())==null)
				{
					List<Person> l = new ArrayList<Person>();
					l.add(p);
					phonebook.put(p.getName(),l);
				}
				else
					phonebook.get(p.getName()).add(p);

				break;
			}

			case 2 :
			{
				System.out.print("Enter the Name of the CONTACT : ");
				String name = in.next();
				phonebook.entrySet().stream().filter(ph -> ph.getKey().startsWith(name)).forEach(ph->display(ph.getValue()));
				break;
			}

			case 3:
			{
				System.out.print("Enter the Number  : ");
				double num = inp.nextDouble();
				phonebook.entrySet().stream().forEach(ph->SearchNum(ph.getValue(),num));
				break;

			}

			case 4:
			{
				System.exit(0);
			}
		}
	}while(true);


	}
}