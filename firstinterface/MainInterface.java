package com.firstinterface;

public class MainInterface 
{
	public static void main(String[] args)
	{
		MyInterface MI=(a,b,c) -> 
		{
			if(c.equals("add"))
				return a+b;
			else if (c.equals("sub"))
				return a-b;
			else if (c.equals("mul"))
				return a*b;
			else if (c.equals("div"))
				return a/b;
			else
				return -1;
		};
		System.out.println(MI.ArthOperation(11, 8, "ad"));
	}

}
