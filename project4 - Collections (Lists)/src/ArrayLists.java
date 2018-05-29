import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/*
Name: Kyle Pamintuan
Date: 10-15-15
Purpose: To test time efficiency with Lists
Inputs: 100 items for the Scavenger Hunt, number of teams desired, position of item for retrieving, item to insert in that position
Outputs: items for each team, item based on position given by user, random items, times of operations
*/

public class ArrayLists 
{	
	public static void main(String[] args) 
	{
		try
		{
			//Create list of 100 Scavenger Hunt items
			ArrayList<String> items = new ArrayList<String>();
			items.add("rock");
			items.add("leaf");
			items.add("stick");
			items.add("plastic bottle");
			items.add("glass bottle");
			items.add("shoelace");
			items.add("black pen");
			items.add("pencil");
			items.add("sock");
			items.add("shirt");		//10
			items.add("pants");
			items.add("shorts");
			items.add("sunglasses");
			items.add("eyeglasses");
			items.add("necklace");
			items.add("sweatshirt");
			items.add("screwdriver");
			items.add("bolt");
			items.add("cup");
			items.add("mug");		//20
			items.add("plate");
			items.add("bowl");
			items.add("box");
			items.add("tissue");
			items.add("scissors");
			items.add("stapler");
			items.add("paperclip");
			items.add("basketball");
			items.add("football");
			items.add("volleyball");		//30
			items.add("tennis ball");
			items.add("soccer ball");
			items.add("sharpie");
			items.add("highlighter");
			items.add("picture");
			items.add("picture frame");
			items.add("blue pen");
			items.add("red pen");
			items.add("shoe box");
			items.add("cologne");		//40
			items.add("perfume");
			items.add("flash drive");
			items.add("ps3 game");
			items.add("ps4 game");
			items.add("pc game");
			items.add("ps3 controller");
			items.add("ps4 controller");
			items.add("keyboard");
			items.add("monitor");
			items.add("mouse");		//50
			items.add("sticky note");
			items.add("notepad");
			items.add("graph paper");
			items.add("line paper");
			items.add("binder");
			items.add("divider");
			items.add("eraser");
			items.add("white out");
			items.add("glove");
			items.add("soap");		//60
			items.add("shampoo");
			items.add("conditioner");
			items.add("towel");
			items.add("deoderant");
			items.add("air freshner");
			items.add("napkin");
			items.add("spoon");
			items.add("fork");
			items.add("buter knife");
			items.add("steak knife");		//70
			items.add("spatula");
			items.add("pot");
			items.add("pan");
			items.add("milk");
			items.add("orange juice");
			items.add("powerade");
			items.add("gatorade");
			items.add("sprite");
			items.add("coke");
			items.add("diet coke");		//80
			items.add("diet sprite");
			items.add("tupperware");
			items.add("light bulb");
			items.add("lamp");
			items.add("blanket");
			items.add("pillow");
			items.add("sandals");
			items.add("shoes");
			items.add("hanger");
			items.add("tv controller");		//90
			items.add("iphone");
			items.add("ipad");
			items.add("bike");
			items.add("scooter");
			items.add("skateboard");
			items.add("longboard");
			items.add("roller skates");
			items.add("tires");
			items.add("floor jack");
			items.add("wrench");		//100
			
			System.out.println("========== Scavenger Hunt ==========");
			System.out.println();
			
			System.out.println("How many teams desired? (Use Digits)");
			int userInput;
			Scanner reader = new Scanner(System.in); //Reads user input
			userInput = reader.nextInt(); //Get user input
			System.out.println();
			
			//Timer for efficiency timing
			Date today = new Date();
			long time1, time2;
			
			ArrayList<ArrayList<String>> teams = new ArrayList<ArrayList<String>>();
			
			 //Shuffle and add items to the teams-------------------------------------------------------------------------------------
			time1 = System.nanoTime(); //Start time
			for(int i = 0; i < userInput; i++)
			{
				Collections.shuffle(items);
				ArrayList abc = (ArrayList)items.clone();
				Collections.copy(abc,items);
				teams.add(abc);
			}
			time2 = System.nanoTime(); //End time
			
			//Print teams and their items----------------------------------------------------------------------------------------------
			ListIterator cursor2 = teams.listIterator();
			int counter = 1; //team counter
			while(cursor2.hasNext())	//loops through teams
			{   	
				System.out.println("Team " + counter + " items:");
			     ArrayList itemElement = (ArrayList)cursor2.next();
			     ListIterator cursor3 = itemElement.listIterator();
			     
			     while (cursor3.hasNext())	//loops through the items
			     {
					 String itemstring = (String)cursor3.next();
					 System.out.println(itemstring);
			     }
			     counter++;
			     System.out.println();
			}
			System.out.println("Time it took to add items to all teams: " + (time2 - time1) + " nanoseconds"); //Resulting time
			time1 = 0; //Reset stop watch
			time2 = 0; //Reset stop watch
			
			System.out.println();
			System.out.println("What item do you want to retrieve from each team? (Give the item's position(1-100)");
			int userInput2 = reader.nextInt();
			
			//Retrieve and print item from each Teams' linked lists based on the position given by user---------------------------------
			time1 = System.nanoTime(); //Start time
			while(cursor2.hasPrevious())//loops through teams
			{
				ArrayList itemElement = (ArrayList)cursor2.previous();
				System.out.println(itemElement.get(userInput2 - 1));
			}
			time2 = System.nanoTime(); //End time
			System.out.println("Time it took to retrieve item from each team: " + (time2 - time1) + " nanoseconds"); //Resulting time
			time1 = 0; //Reset stop watch
			time2 = 0; //Reset stop watch
			
			System.out.println();
			System.out.println("What item do you want to insert in this position? (This will replace the items)");
			String userInput3 = reader.next();
			
			//Remove and insert a new item in that position-----------------------------------------------------------------------------
			time1 = System.nanoTime(); //Start time
			while(cursor2.hasNext())//loops through teams
			{
				ArrayList itemElement = (ArrayList)cursor2.next();
				itemElement.remove(itemElement.get(userInput2 - 1));
				itemElement.add(userInput3);
				//System.out.println(itemElement.get(userInput2 - 1)); //Tests to see if element insertion was successful
			}
			time2 = System.nanoTime(); //End time
			System.out.println("Time it took insert item for each team: " + (time2 - time1) + " nanoseconds"); //Resulting time
			time1 = 0; //Reset stop watch
			time2 = 0; //Reset stop watch
			
			System.out.println();
			System.out.println("Random Items: ");
			
			//Print random item from each Team's list----------------------------------------------------------------------------------
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100);
			
			time1 = System.nanoTime(); //Start time
			while(cursor2.hasPrevious())//loops through teams
			{
				ArrayList itemElement = (ArrayList)cursor2.previous();
				System.out.println(itemElement.get(randomInt - 1));
			}
			time2 = System.nanoTime(); //End time
			System.out.println("Time it retrieve random item: " + (time2 - time1) + " nanoseconds");
		}
		catch (InputMismatchException e)
		{
			e.printStackTrace();
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
	}
}
