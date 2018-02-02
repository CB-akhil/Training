public class Author{
	private String name,email;
	private char gender;
	Author(String name,String email,char gender){
		this.name=name;
		this.email=email;
		this.gender=gender;
	}
	public String getName(){
		return name;
	}
	public String getemail(){
		return email;
	}
	public void setEmail(String input){
		email=input;
	}
	public char getGender(){
		return gender;
	}
	public String toDisplay(){
		return String.format("%s %c at %s",name,gender,email);
	}
	public static void main(String[] args) {
		Author rk = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
		System.out.println(rk.toDisplay());
		rk.setEmail("new@email");
		System.out.println(rk.toDisplay());
	}
}