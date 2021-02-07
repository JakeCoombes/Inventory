import java.io.*;
import java.util.*;


public class Inventory 
{
		//attributes
	private Item itemArray[] = new Item[100];
	private int totalItems = 0;
		
		//methods
	public int getTotalNumberOfItems()
	{ return (totalItems);	} 
	
	public Item getItem(int index)
	{ 		//check if the inventory index is out of bounds
		if(index < 0 || index >= totalItems)
			return(null);
		else	//if it isn't return the item
			return(itemArray[index]);	
	}	
	
	public void addItem(Item newItem)
	{		//check if the item exists
		if (newItem == null)
		{
			System.out.println("Item not added");
		}	//if the item does exist add it to the inventory array
		else
		{
			itemArray[totalItems] = newItem;
			totalItems++;
		}
	}	
	
	public void saveInventoryToFile(String fileName) throws FileNotFoundException
	{	
			//create an instance of the text writer
		PrintWriter output = new PrintWriter(fileName);
			//add every item from the inventory array to a text file
		for (int c=0; c<totalItems; c++)
		{
			output.println(itemArray[c].getName());
			output.println(itemArray[c].getQuantity());
			output.println(itemArray[c].getPrice());
			output.println(itemArray[c].getUPC());
		}
		output.close();
	}	

	public void loadInventoryFromFile(String fileName)
	{	
			//create an instance of the text scanner
			File input = new File(fileName);
		
		try
		{		//variables
			Scanner in = new Scanner(input);
			String name;
			int qty;
			double price;
			String UPC;
			
				//check if the file has another item
			while(in.hasNext())
			{		//while it does add the item to the inventory array
				name = in.nextLine();
				qty = in.nextInt();
				in.nextLine();
				price = in.nextDouble();
				in.nextLine();
				UPC = in.nextLine();
				
				Item temp = new Item(name, qty, price, UPC);
				addItem(temp);
			}		
			in.close();
				//tell the user the inventory was loaded
			System.out.println("Inventory Loaded\n");
		}catch(FileNotFoundException e) {
				//if the file doesn't exist tell the user
			System.out.println("File Does Not Exists\n");
		}
		
		
	}
}
