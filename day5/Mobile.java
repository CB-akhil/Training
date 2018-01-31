class Mobile{
	String name;
	int remainCharge=0;
	public void remainCharge(){
		remainCharge=50;
	}
	public void printCharge(){
		System.out.println("remaing Charge: " + remainCharge);
	}
	public static void main(String[] args) {
		Mobile lava = new Mobile(){
			//overriding using anonymous Inner class
			public void remainCharge(){
				remainCharge=10;
			}
		};
		lava.remainCharge();
		lava.printCharge();
		Mobile onePlus = new Mobile(){
			public void remainCharge(){
				remainCharge=99;
			}
		};
		onePlus.remainCharge();
		onePlus.printCharge();
	}
}