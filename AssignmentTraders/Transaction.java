package com.stream.AssignmentTraders;

public class Transaction {
private Trader trader;
private int year;
private int value;

public Transaction(Trader trader2, int year2, int value2) {
	super();
	this.trader = trader2;
	this.year = year2;
	this.value = value2;
}
public Trader getTrader() {
	return trader;
}
public int getYear() {
	return year;
}
public int getValue() {
	return value;
}
@Override
public String toString() {
	return "" + trader + ", year=" + year + ", value=" + value + "";
}

}


