import java.util.Scanner;
class Day2{
	/*void swap(int a,int b){
		int temp;
		temp=a;
		a=b;
		b=temp;
	}*/
	public static int[] fibonacci(int n){
        /* Declare an array to store Fibonacci numbers. */
	    int f[] = new int[n+1];
	    int i;  
	    /* 0th and 1st number of the series are 0 and 1*/
	    f[0] = 0;
	    f[1] = 1;
	    for (i = 2; i <= n; i++){
	       /* Add the previous 2 numbers in the series
	         and store it */
	        f[i] = f[i-1] + f[i-2];
	    }
    	return( f );
    }
      
   
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//pattern 
		System.out.println("Enter number of lines");
		int lines=scanner.nextInt();
		for(int i=0;i<lines;i++){
			for(int j=0;j<lines-(i+1);j++)
				System.out.print(" ");
			for(int j=0;j<i;j++)
				System.out.print(j+1);
			for(int j=i+1;j>0;j--)
				System.out.print(j);
			System.out.println();
		}
		// rotate left or right
		int array[][]={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("chose true for left or false for right");
		Boolean choice=scanner.nextBoolean();
		int size=3;
		//System.out.println((int)Math.ceil((float)3/2));
		for(int i=0;i<size/2;i++){
			for(int j=0;j<(int)Math.ceil((float)size/2);j++){
				if(choice){
					//System.out.println("running for j value "+j);
					int temp=array[i][j];
					array[i][j]=array[j][size-i-1]; //first row will be replaced by last coloum
					array[j][size-i-1]=array[size-i-1][size-j-1]; //last coloum by bottom row
					array[size-i-1][size-j-1]=array[size-j-1][i]; //bottom row by first coloum
					array[size-j-1][i]=temp; //first coloum by fitst row
				}else{
					//same as above but in clockwise direction
					int temp=array[i][j];
					array[i][j]=array[size-j-1][i];
					array[size-j-1][i]=array[size-i-1][size-j-1];
					array[size-i-1][size-j-1]=array[j][size-i-1];
					array[j][size-i-1]=temp;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		// simple and compund intrest
		System.out.println("enter number of years");
		int n=scanner.nextInt();
		System.out.println("principle amount");
		int p=scanner.nextInt();
		System.out.println("intrest rate:");
		int r=scanner.nextInt();
		System.out.println("simple intrest: "+ p*n*(float)r/100); 
		System.out.println("compund intrest: " + p*Math.pow((1+ (float)r/100),n));

		//febonnaci series upto n
		System.out.println("Enter n value");
		n=scanner.nextInt();
		int fib[]=fibonacci(n);
		System.out.println("fibonacci series:");
		for(int i=0;i<fib.length;i++){
			System.out.print(fib[i]+" ");
		}
		System.out.println();
		//largest and smalest in array
		int array1[]={1,4,2,5,3,8,9};
		int min=array1[0],max=array1[0];
		for(int i=1;i<array1.length;i++){
			max=((max>array1[i])?max:array1[i]);
			min=(min<array1[i])?min:array1[i];
			//System.out.println("min "+ min +" max "+ max);
		}
		System.out.println("mininum : "+min);
		System.out.println("maximum: "+max);
	}	
}
