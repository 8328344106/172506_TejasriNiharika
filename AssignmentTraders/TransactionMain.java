package com.stream.AssignmentTraders;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionMain {

	public static void main(String[] args) {
		List<Transaction> list=new ArrayList<>();
		list.add(new Transaction(new Trader("manu", "Pune"),2011,2000));
		list.add(new Transaction(new Trader("mahesh","Hyderabad"),2012,3000));
		list.add(new Transaction(new Trader("kishan", "Indore"),2011,5000));
		list.add(new Transaction(new Trader("kiki", "Pune"),2015,20000));
		list.add(new Transaction(new Trader("maahi", "Indore"),2011,6000));
		list.add(new Transaction(new Trader("ankit", "Delhi"),2016,8000));
		list.add(new Transaction(new Trader("vijay", "Pune"),2017,9000));
		list.add(new Transaction(new Trader("aakash", "Delhi"),2011,10000));
		list.add(new Transaction(new Trader("akshay", "Pune"),2012,9800));
		list.add(new Transaction(new Trader("yakya", "Indore"),2014,1000));
		list.add(new Transaction(new Trader("ankeeyt", "Delhi"),2013,6000));
		list.add(new Transaction(new Trader("lokiya", "Indore"),2012,18000));
		list.add(new Transaction(new Trader("kagesh", "Delhi"),2018,80000));
		
		List<Transaction> trans=list.stream()
				.filter(p->p.getYear()==2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		trans.forEach(e->System.out.println("transaction value: "+e.getValue()+" in the year "+e.getYear()+" done by "+e.getTrader().getName()));
		
		
		List<Transaction> trans2=list.stream()
				.filter(p->p.getTrader().getCity()=="Delhi")
				.collect(Collectors.toList());
		trans2.forEach(e->System.out.println("Transaction value is: "+e.getValue()+" done by "+e.getTrader().getName()));
		
		
		Transaction max=list.stream()
				.max((p1,p2)->Integer.compare(p1.getValue(), p2.getValue()))
				.get();
		System.out.println(max.getValue());
		
		
		Transaction max2=list.stream()
				.min((p1,p2)->Integer.compare(p1.getValue(), p2.getValue()))
				.get();
		System.out.println(max2.getValue());
	}

}
