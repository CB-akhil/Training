import java.util.*;
class Mobile{
	String name;
	int remainCharge=0;
	public void remainCharge(){
		this.remainCharge=50;
	}
	public void printCharge(){
		System.out.println("remaing Charge: " + remainCharge);
	}
	public static void main(String[] args) {
		List<Mobile> list = new ArrayList<>();
		Mobile lava = new Mobile(){
			//overriding using anonymous Inner class
			public void remainCharge(){
				remainCharge=10;
			}
		};
		lava.remainCharge();
		list.add(lava);
		lava.printCharge();
		Mobile onePlus = new Mobile(){
			public void remainCharge(){
				remainCharge=99;
			}
		};
		onePlus.remainCharge();
		list.add(onePlus);
		onePlus.printCharge();
		for(Mobile m:list)
			m.printCharge();
	}
}