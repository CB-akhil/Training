class Day1{
   public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
      System.out.println("Hello, World");
      // declaring two vairable and printing its output
      int x=3,y=50;
      System.out.println(x+y);
      //conditonal statement
      if(x+y == 7){
      	System.out.println("sum is 7");
      }else{
      	System.out.println("sum is " + (x+y));
      }
      //smallest power of x greater than y
      int ans=0;
      while(y/x != 0){
            System.out.println("y:" +y +"x:" + x );
      	y/=x;
      	ans++;
            System.out.println("y:" +y +"x:" + x );
      }
      System.out.println(ans + 1 );

   }
}