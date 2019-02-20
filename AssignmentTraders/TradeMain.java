package com.stream.AssignmentTraders;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradeMain {

	public static void main(String[] args) {
		List<Trader> list=new ArrayList<>();
		list.add(new Trader("manu", "Pune"));
		list.add(new Trader("mahesh","Hyderabad"));
		list.add(new Trader("kishan", "Indore"));
		list.add(new Trader("kiki", "Pune"));
		list.add(new Trader("maahi", "Indore"));
		list.add(new Trader("ankit", "Bangalore"));
		list.add(new Trader("vijay", "Pune"));
		list.add(new Trader("aakash", "Indore"));
		list.add(new Trader("akshay", "Pune"));
		list.add(new Trader("yakya", "Indore"));
		
		System.out.println("Unique Cities are>>>>>");
		List<String> names3=list.stream()
				.map(Trader::getCity)
				.distinct()
				.collect(Collectors.toList());
		names3.forEach(System.out::println);
		
		List<Trader> names=list.stream()
				.filter(p->p.getCity()=="Pune")
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		names.forEach(System.out::println);
		
		System.out.println("Traders names are>>>>>");
		List<Trader> names4=list.stream()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		String S=names4.stream()
				.map(Trader::getName)
				.collect(Collectors.joining(", "));
		System.out.println(S);
		
		System.out.println("Traders based in Indore are_>>>>>");
		List<String> names2=list.stream()
				.filter(p->p.getCity()=="Indore")
				.map(Trader::getName)
				.collect(Collectors.toList());
		names2.forEach(System.out::println);
		
		
		
		
	}

}
