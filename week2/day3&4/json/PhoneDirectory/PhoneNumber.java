package PhoneDirectory;
import java.util.*;
class PhoneNumber
{
	private String number ;
	private Type t;
	PhoneNumber(String number,Type t)
	{
		this.number = number;
		this.t = t;
	}
	public static enum Type{
		MOBILE,HOME,WORK;
	}

	public String getPhNumber(){
		return number;
	}

}