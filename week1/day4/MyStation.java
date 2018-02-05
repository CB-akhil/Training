
import java.util.*;

class Station{
    String name;
    String address;
    String contact;
    List<Vechile> vechiles=new ArrayList<>();
    List<Employee> employees=new ArrayList<>();
    List<Customer> customers=new ArrayList<Customer>();
    Station(String name,String address,String contact,List<Vechile> vechiles){
        this.name=name;
        this.address=address;
        this.contact=contact;
        this.vechiles=vechiles;
    }
    void addCustomer(Customer input){
        customers.add(input);
    }
    void addEmployee(Employee input){
        employees.add(input);
    }
}
abstract class Person{
    String name,contact;
    int age;
    Person(String name,String contact,int age){
        this.name=name;
        this.contact=contact;
        this.age=age;
    }
}
class Customer extends Person{
    List<Invoice> invoices= new ArrayList<>();
    Customer(String name,String contact,int age){
        super(name,contact,age);
    }
    public void addInvoice(Invoice input){
        invoices.add(input);
    }
}
class Employee extends Person{
    int employeeId;
    public Employee(String name, String contact, int age,int id) {
        super(name, contact, age);
        employeeId=id;
    }
}
class Vechile{
    String brand,color;
    Service service;
    Vechile(String brand,String color,String type,double charge){
        this.brand=brand;
        this.color=color;
        service= new Service(type,charge);
    }   
}
class Service{
    String type;
    double serviceCharge;
    Service(String type,double charge){
        this.type=type;
        serviceCharge=charge;
    }
}
class Invoice{
    Person customer;
    Vechile vechile;
    Employee employeeAssigned;
    Invoice(Person customer,Vechile v,Employee assigned){
     this.customer=customer;
     this.vechile=v;
     this.employeeAssigned=assigned;
    }
    
}
public class MyStation{
    public static void main(String[] args){
        List<Vechile> vechiles = new ArrayList<Vechile>();
        Vechile v = new Vechile("ford","blue","car",51.2);
        vechiles.add(v);
        v = new Vechile("India","blue","car",51.2);
        vechiles.add(v);
        v = new Vechile("Innova","blue","car",51.2);
        vechiles.add(v);
        Station s = new Station("ChargeBee","sp Infocity","1234",vechiles);
        System.out.println("lsit of vechile repaired in Station");
        for(Vechile d: s.vechiles){
            System.out.println(d.brand);
        }
        Employee emp= new Employee("cb","abc",1,1);
        s.addEmployee(emp);
        Customer akhil = new Customer("Akhil","9492350615",21);
        Invoice in = new Invoice(akhil,v,emp);
        akhil.addInvoice(in);
        s.addCustomer(akhil);
        System.out.println("lsiting all the Employess");
        for(Employee e:s.employees){
            System.out.println(e.name);
        }
        System.out.println("lsiting all the customers along with INvoices:");
        for(Customer e:s.customers){
            System.out.println("Printing Invoices of customer " + e.name);
            for(Invoice i:e.invoices){
                System.out.println("vechile name:"+i.vechile.brand);
                System.out.println("assigned employee : " +i.employeeAssigned.name);
                System.out.println("service charge "+i.vechile.service.serviceCharge);
                System.out.println("Servie type : " + i.vechile.service.type);
            }
        }
            
    }
}