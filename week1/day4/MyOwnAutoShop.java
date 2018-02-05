abstract class Car{
	int speed;
	double regularPrice;
	String color;
        Car(int speed,double price,String color){
            this.speed=speed;
            this.regularPrice=price;
            this.color=color;
        }
	abstract double getSalePrice();
        abstract void display();
}
class Truck extends Car{
    int weight;
    Truck(int speed,double price,String color,int weight){
        super(speed,price,color);
        this.weight=weight;
    }
    @Override
    double getSalePrice(){
        double result;
        if(weight > 2000 ){
            result=0.9 * regularPrice;
        }else{
            result=0.8 * regularPrice;
        }
        return result;
    }
    @Override
    void display(){
        System.out.println("Dispaying Truck");
        System.out.println("speed: "+speed);
        System.out.println("price: "+regularPrice);
        System.out.println("color: "+color);
        System.out.println("weight: "+weight);
        System.out.println("Sale price: "+this.getSalePrice());
    }
}
class Ford extends Car{
    int year;
    int manifacturerDiscount;
    Ford(int speed,double price,String color,int year,int mDiscount){
        super(speed,price,color);
        this.year=year;
        this.manifacturerDiscount=mDiscount;
    }
    @Override
    double getSalePrice(){
        return regularPrice-manifacturerDiscount;
    }
    @Override
    void display(){
        System.out.println("Dispaying Truck");
        System.out.println("speed: "+speed);
        System.out.println("price: "+regularPrice);
        System.out.println("color: "+color);
        System.out.println("year: " + year);
        System.out.println("Sale price: "+this.getSalePrice());
    }
}
class Sedan extends Car{
    int length;
    Sedan(int speed,double price,String color,int length){
        super(speed,price,color);
        this.length=length;
    }
    @Override
    double getSalePrice(){
        if(length > 20)
            return .95 * regularPrice;
        else
            return .9 * regularPrice;
    }
    @Override
    void display(){
        System.out.println("Dispaying Truck");
        System.out.println("speed: "+speed);
        System.out.println("price: "+regularPrice);
        System.out.println("color: "+color);
        System.out.println("length: "+ length);
        System.out.println("Sale price: "+this.getSalePrice());
    }
}
public class MyOwnAutoShop{
    public static void main(String[] args){
        System.out.println("Dispaying Truck");
        Sedan sedan = new Sedan(100,275.5,"white",20);
        Ford f1 = new Ford(85,301.5,"Blue",2017,50);
        Ford f2 = new Ford(95,311.5,"Black",2018,55);
        sedan.display();
        f1.display();
        f2.display();
    }
}