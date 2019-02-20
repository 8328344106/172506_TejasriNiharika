package com.FirstLetter;

import java.util.ArrayList;

public class FirstLetter 
{

	public static void main(String[] args) 
	{
		ArrayList<String> list=new ArrayList<>();
		list.add("Tejasri");
		list.add("Niharika");
		list.add("Sri");
		list.add("Harika");
		StringBuilder str=new StringBuilder();
		list.forEach(s->str.append(s.charAt(0)));
		System.out.println(str);

	}

}
