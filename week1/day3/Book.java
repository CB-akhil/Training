import java.util.*;
public class Book{
	private String name;
	private List<Author> authors = new ArrayList<Author>();
	private double price;
	private int qtyInStock=0;
	Book(String name,Author[] authors,double price,int qtyInStock){
		this.name=name;
		for(Author author:authors)
			this.authors.add(author);
		this.price=price;
		this.qtyInStock=qtyInStock;
	}
	Book(String name,Author author,double price,int qtyInStock){
		this.name=name;
		authors.add(author);
		this.price=price;
		this.qtyInStock=qtyInStock;
	}
	public String getName(){
		return name;
	}
	public List<Author> getAuthors(){
		return authors;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public int getQtyInStock(){
		return qtyInStock;
	}
	public void setQtyInStock(int QtyInStock){
		this.qtyInStock=QtyInStock;
	}
	public String toDisplay(){
		String output="";
		output=output.concat(String.format("%s by", name));
		for(Author author : authors){
			output=output.concat(",");
			output=output.concat(String.format("%s",author.toDisplay()));
		}
		output=output.concat(String.format("price : %f",price));
		output=output.concat(String.format("Number of Books available : %d",qtyInStock));
		return output;
	}

	public void printAuthors(){
		for(Author author: authors){
			System.out.println(author.toDisplay());
		}
	
	}

	public void addAuthor(Author author){
		authors.add(author);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Book Name:");
		String name=scanner.next();
		System.out.println("Enter Book Price:");
		double price =scanner.nextDouble();
		System.out.println("Enter Number of Books available:");
		int qty=scanner.nextInt();
		Author rk = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
		Book b=new Book(name,rk,price,qty);
		Author ak= new Author("Akhil Surapuram", "akhil@chargebee.com", 'M');
		b.addAuthor(ak);
		b.printAuthors();
		List<Book> books = new ArrayList<Book>();
		books.add(b);
		System.out.println("Enter Book Name:");
		name=scanner.next();
		System.out.println("Enter Book Price:");
		price =scanner.nextDouble();
		System.out.println("Enter Number of Books available:");
		qty=scanner.nextInt();
		b = new Book(name,rk,price,qty);
		books.add(b);
		System.out.println("Enter Book Name to Display its Author:");
		name=scanner.next();
		// Need to ask doubt why can't i use previously declared b(reference) for iterating through loops
		for(Book c : books){
			if( name.equalsIgnoreCase(c.getName())){
				//System.out.println("condition satisfied");
				c.printAuthors();
			}
		}
		
		System.out.println("Displaying all avail Books:");
		for(Book c : books){
			if(c.getQtyInStock() != 0)
				System.out.println(c.toDisplay());
		}

	}
}