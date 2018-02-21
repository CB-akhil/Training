package prog;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
public class DateFormat
{
	public static String changeDateFormat(String date,String format) throws Exception
	{
		SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.US);
		SimpleDateFormat sd2 = new SimpleDateFormat(format) ;
		sd1.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strout="";
	try	{
			Date dDate = (Date)sd1.parse(date);
			strout = sd2.format(dDate);
		}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		return strout;
	}	 
}
}