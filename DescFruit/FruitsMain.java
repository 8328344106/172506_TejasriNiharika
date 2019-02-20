package com.DescFruit;

public class FruitsMain {

	public static void main(String[] args) 
	{
		FruitArrayList FAR=new FruitArrayList();
		Fruit f1=new Fruit("Apple",10,50,"Red");
		Fruit f2=new Fruit("orange",50,50,"Orange");
		Fruit f3=new Fruit("Mango",120,25,"Green");
		Fruit f4=new Fruit("Banana",30,30,"Yellow");
		Fruit f5=new Fruit("Straberry",10,100,"Red");
		FAR.addnew(f1);
		FAR.addnew(f2);
		FAR.addnew(f3);
		FAR.addnew(f4);
		FAR.addnew(f5);
		FAR.display();
		System.out.println("-----------------------------------------");
		FAR.sort();
		System.out.println("-----------------------------------------");
		FAR.SortFruitname();
		System.out.println("-----------------------------------------");
		FAR.SortFruitPrice();
	}

}
