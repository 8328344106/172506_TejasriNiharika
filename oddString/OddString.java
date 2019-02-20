package com.oddString;

import java.util.ArrayList;

public class OddString 
{

	public static void main(String[] args) 
	{
		ArrayList<String> list=new ArrayList<>();
		list.add("Tejasri");
		list.add("Niharika");
		list.add("Sri");
		list.add("Harika");
		list.removeIf(n -> (n.length()%2 != 0));
		for(String s : list)
			System.out.println(s);
	}

}
