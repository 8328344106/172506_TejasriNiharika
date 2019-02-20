package com.pricecal;

public class MainOrder 
{

	public static void main(String[] args) 
	{
		Order o=(price,orStatus) ->
		{
			if(price > 10000 && (orStatus.equals("Accepted")||orStatus.equals("Completed")))
			{
				System.out.println("Price: "+price+" Status: "+orStatus);
			}
		};
		o.orders(1200,"Rejected");
		o.orders(12000, "Accepted");
		o.orders(13300, "Completed");
		o.orders(1200,"Accepted");

	}

}
