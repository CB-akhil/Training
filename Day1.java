class Day1{
   public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
      System.out.println("Hello, World");
      // declaring two vairable and printing its output
      int x=2,y=5;
      System.out.println(x+y);
      //conditonal statement
      if(x+y == 7){
      	System.out.println("sum is 7");
      }else{
      	System.out.println("sum is %d" + x+y);
      }
      //smallest power of x greater than y
      int ans=0;
      while(y/x != 0){
      	y/=x;
      	ans++;
      }
      System.out.println(ans + 1 );

   }
}