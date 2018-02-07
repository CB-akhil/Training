package PhoneDirectory;
import java.util.*;
class PhoneNumber
{
	private double number ;
	private Type t;
	PhoneNumber(double number,Type t)
	{
		this.number = number;
		this.t = t;
	}
	public static enum Type
	{
		MOBILE,HOME,WORK;
	}

	public double getPhNumber()
	{
		return number;
	}

}