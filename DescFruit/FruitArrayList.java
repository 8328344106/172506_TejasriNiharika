package com.DescFruit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class FruitArrayList 
{

	ArrayList<Fruit> fruits=new ArrayList<>();
	void addnew(Fruit f)
	{
		fruits.add(f);
	}
	void display()
	{
		fruits.forEach(System.out::println);
	}
	void sort()
	{
			List<Fruit> result = fruits.stream().filter(p->p.getCalaries()<100).sorted().collect(Collectors.toList());
			result.forEach(System.out::println);
		
	}
	void SortFruitname()
	{
		List<Fruit> result = fruits.stream().sorted(Comparator.comparing(Fruit::getColor)).collect(Collectors.toList());
		result.forEach(e->System.out.println("Name: "+e.getName()+" Color: "+e.getColor()));
	}
	void SortFruitPrice()
	{
		List<Fruit> result = fruits.stream().filter(c->c.getColor()=="Red").sorted(Comparator.comparing(Fruit::getPrice)).collect(Collectors.toList());
		result.forEach(e->System.out.println("Color: "+e.getColor()+" Price: "+e.getPrice()));
	}
	
	
}
