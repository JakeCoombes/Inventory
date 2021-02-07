//import java.util.*;

public class Item 
{
	//attributes
	private String name;
	private int quantity;
	private double price;
	private String upc;
	
	//constructor
	private Item()
	{	}	
	//methods
	public Item(String name, int qty, double price, String upc)
	{	
		this.name 		= name;
		this.quantity 	= qty;
		this.price 		= price;
		this.upc 		= upc;
	}	
		//getters
	public String getName()
	{ return(name);		}
	public int getQuantity()
	{ return(quantity);	}
	public double getPrice()
	{ return(price);	}	
	public String getUPC()
	{ return(upc);		}
}
