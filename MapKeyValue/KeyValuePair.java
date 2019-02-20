package MapKeyValue;

import java.util.Map;
import java.util.TreeMap;

public class KeyValuePair 
{

	public static void main(String[] args) 
	{

		Map<String,Integer> list=new TreeMap<>();
		list.put("Niha", 1);
		list.put("Gopal", 2);
		list.put("Maha", 3);
		list.put("Mouni", 4);
		StringBuilder str=new StringBuilder();
		list.forEach((key,value)->str.append(key+value));
		System.out.println(str);
	}

}
