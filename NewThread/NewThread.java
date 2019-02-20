package NewThread;

import java.util.ArrayList;

public class NewThread {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Thread thread = new Thread()
		{
		    public void run()
		    {
		    	list.forEach(System.out::println);
		    }
		};
		thread.start();


	}

}
