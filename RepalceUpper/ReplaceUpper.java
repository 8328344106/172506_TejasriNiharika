package RepalceUpper;

import java.util.ArrayList;

public class ReplaceUpper 
{

	public static void main(String[] args) 
	{
		ArrayList<String> list=new ArrayList<>();
		list.add("Tejasri");
		list.add("Sri");
		list.add("Niharika");
		list.add("Harika");
		list.replaceAll(s->s.toUpperCase());
		list.forEach(System.out::println);
	}

}
