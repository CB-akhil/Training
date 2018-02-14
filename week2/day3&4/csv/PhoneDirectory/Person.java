package PhoneDirectory;
import java.util.*;
class Person
{
	private String name;
	private String address;
	private ArrayList<PhoneNumber> numbers = new ArrayList<>();
	public void addContact(String name,String address,String number,int type)
	{
		this.name = name;
		this.address = address;
		addNumber(number,type);
	}
	public void addContact(String name,String address){
		this.name = name;
		this.address = address;
	}
	public void addNumber(String num,int ch){
			if(ch == 1){
				numbers.add(new PhoneNumber(num,PhoneNumber.Type.MOBILE));
			}
			else if(ch==2){
				numbers.add(new PhoneNumber(num,PhoneNumber.Type.HOME));
			}
			else{
				numbers.add(new PhoneNumber(num,PhoneNumber.Type.WORK));
			}
	}
	public String getName()
	{
		return this.name;
	}
	public String getAddress()
	{
		return this.address;
	}

	public ArrayList<String> getNumbers()
	{
		ArrayList<String> num = new ArrayList<String>();
		for(PhoneNumber n : numbers)
		{
			num.add(n.getPhNumber());
		}
		return num;
	}

}