package com.DescFruit;

public class Fruit implements Comparable<Fruit>
{
	String name;
	int calaries;
	int price;
	String color;
	public Fruit(String name, int calaries, int price, String color) 
	{
		this.name = name;
		this.calaries = calaries;
		this.price = price;
		this.color = color;
	}
	public String getName() 
	{
		return name;
	}
	public int getCalaries() 
	{
		return calaries;
	}
	public int getPrice() 
	{
		return price;
	}
	public String getColor() 
	{
		return color;
	}
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", calaries=" + calaries + ", price=" + price + ", color=" + color + "]";
	}
	@Override
	public int compareTo(Fruit f) 
	{
		return f.getCalaries()-this.calaries;
		//return 0;
	}
	
}
