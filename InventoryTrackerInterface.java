import java.io.*;
import java.util.*;

public class InventoryTrackerInterface
{
		//main method
	public static void main(String[] args) throws FileNotFoundException 
	{
			//variables 
		Scanner input = new Scanner(System.in);
		Inventory inv = new Inventory();
		int choice;
		
			// run the program at least once
		do 
		{
				//print menu
			System.out.println("1. Add an item to the inventory");
			System.out.println("2. Get an item from the inventory");
			System.out.println("3. Save inventory to file");
			System.out.println("4. Load inventory from file");
			System.out.println("5. Exit");
				//scan for user choice
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1:		// add item
				input.nextLine();
					//get info about the new item
				System.out.println("Enter the new items name");
				String name = input.nextLine();
				System.out.println("Enter the new items quantity");
				int qty = input.nextInt();
				System.out.println("Enter the new items price");
				double price = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the new items UPC");
				String UPC = input.nextLine();
				
				//store the items info into a temporary item class
				Item temp = new Item(name, qty, price, UPC);
				
				//add the info into the inventory
				inv.addItem(temp);
				break;
				
			case 2:		// get item
					//make sure the inventory has at least 1 item in it
				if(inv.getItem(0) != null)
				{
					//get what item they want to see
					System.out.println("which item would you like info for? [0-" + (inv.getTotalNumberOfItems()-1) + "]");
					int index = input.nextInt();
					
						//check if the index requested exists
					if( -1 < index && index < inv.getTotalNumberOfItems())
					{
						//print the items info
						System.out.println("Name: " 	+ inv.getItem(index).getName());	
						System.out.println("Quantity: " + inv.getItem(index).getQuantity());	
						System.out.println("Price: " 	+ inv.getItem(index).getPrice());	
						System.out.println("UPC: " 		+ inv.getItem(index).getUPC());	
						System.out.println();
					}
					else	//if the index doesn't exist tell the user
						System.out.println("Item does not exist\n");
				}
				else
				{	//tell the user if the inventory is empty
					System.out.println("No items in Inventory\n");
				}
				break;
				
			case 3:		// save inventory
					//save the inventory to inventory.txt
				inv.saveInventoryToFile("inventory.txt");
					//tell the user it was saved
				System.out.println("Inventory saved\n");
				break;
				
			case 4:		// load inventory
				
				//load the inventory
				inv.loadInventoryFromFile("inventory.txt");
				break;
				
			case 5:		// exit 
				break;
			
			default:	//default
					//tell user their choice was invalid 
				System.out.println("Invalid option");
				break;
			}
			//exit code if the user wants
		}while(choice != 5);
		
		// tell the user the code is over
		System.out.println("Goodbye");
		
		//close remaining inputs
		input.close();
	}
}
