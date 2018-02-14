package PhoneDirectory;
import java.io.*;
import java.lang.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.nio.file.*;
import java.util.*;
class PhoneBook{
	static Map<String,List<Person>> phonebook = new HashMap<String,List<Person>>();
	public static void display(List<Person> p){
		for(Person per : p){
			System.out.println("\n"+per.getName());
			System.out.println(per.getAddress());
			for(String d: per.getNumbers())
			System.out.printf("%s\n",d);
		}
	}
	public static void SearchNum(List<Person> p,String num){
		for(Person per: p){
			for(String d: per.getNumbers()){
				if(d == num)
					System.out.println(per.getName());
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);
		int ch ;
		try (
			Reader csvData = new FileReader("PhoneDirectory/input.csv");
            CSVParser parser = CSVParser.parse(csvData,CSVFormat.RFC4180);
		){
			//System.out.print("inside try");
			Iterable<CSVRecord> csvRecords = parser.getRecords();
			String name,address;
			String number;
			int type;
			for(CSVRecord c:csvRecords){
				name=c.get(0);
				address=c.get(1);
				number=c.get(2);
				type=Integer.parseInt(c.get(3));
				Person p = new Person();
				p.addContact(name,address,number,type);
				if(phonebook.get(p.getName())==null){
					List<Person> l = new ArrayList<Person>();
					l.add(p);
					phonebook.put(p.getName(),l);
				}else{
					phonebook.get(p.getName()).add(p);
				}
				//System.out.print(phonebook.size());
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		do{	
			System.out.println("\n1.ADD CONTACT");
			System.out.println("2.SEARCH CONTACT BY NAME");
			System.out.println("3.SEARCH CONTACT BY NUMBER");
			System.out.println("4.EXIT");
			System.out.println("\n Enter Your CHoice : ");
			ch = inp.nextInt();
			switch(ch)
			{
				case 1:
					Person p = new Person();
					String name,address;
					String number;
					int type;
					System.out.println("Enter Name:");
					name=in.next();
					System.out.println("Enter Address:");
					address=in.next();
					System.out.println("Enter Mobile Number:");
					number=in.next();
					System.out.println("Enter type (1 for Mobile,2 for Home and 3 for Work):");
					type=in.nextInt();
					p.addContact(name,address,number,type);
					if(phonebook.get(p.getName())==null){
						List<Person> l = new ArrayList<Person>();
						l.add(p);
						phonebook.put(p.getName(),l);
					}
					else{
						phonebook.get(p.getName()).add(p);
					}
					break;

				case 2 :
					System.out.print("Enter the Name of the CONTACT : ");
					name = in.next();
					phonebook.entrySet().stream().filter(ph -> ph.getKey().startsWith(name)).forEach(ph->display(ph.getValue()));
					break;

				case 3:
					System.out.print("Enter the Number  : ");
					String num = inp.next();
					phonebook.entrySet().stream().forEach(ph->SearchNum(ph.getValue(),num));
					break;

				case 4:
					System.exit(0);
			}
		}while(true);
	}
}