import java.util.*;
public class Factorial implements Iterable<Integer>
{
	int lowerlimit;
	int upperlimit;
	Factorial(int a,int b)
	{
		lowerlimit = a;
		upperlimit = b;
	}

	public class Iter implements Iterator<Integer>
	{

		private int fact(int n)
		{
			if(n==0)
				return 0;
			if(n==1)
				return 1;
			else
				return n*fact(n-1); 
		}

		public boolean hasNext()
		{
			return (lowerlimit <= upperlimit);
		}

		public Integer next()
		{
			return fact(lowerlimit++);
		}
	}

	public Iterator<Integer> iterator()
	{
		return new Factorial.Iter();
	}

	public String toString()
	{
		String str ="";
		for(int i : this)
		{
			str+=i+" ";
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lowerlimit;
		int upperlimit;
		System.out.println("Enter the lowerlimit : ");
		lowerlimit = in.nextInt();
		System.out.println("Enter the upperlimit : ");
		upperlimit = in.nextInt();
		Factorial f = new Factorial(lowerlimit,upperlimit);
		System.out.println(f.toString());
	}
}