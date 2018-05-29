import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
Name: Kyle Pamintuan
Date: 10-15-15
Purpose: To test time efficiency with Sets
Inputs: text file of the novel "Alice in Wonderland"
Outputs: time it takes to add words from the text file to a HashSet, times of operations
*/

public class HashSets 
{
	public static void main(String[] args)
	{	
		try 
		{
			//Timer for efficiency timing
			Date today = new Date();
			long time1, time2;
			
			//Initialize variables
			Set<String> hash = new HashSet<String>();
			File inputFile = new File("alice13a.txt"); //Open file
			Scanner in = new Scanner(inputFile);
			
			//Add words from alice13a.txt to the HashSet
			time1 = System.nanoTime();	//Start Time
			while (in.hasNext())
			{
				String data = in.nextLine();
				hash.add(data);
			}
			time2 = System.nanoTime(); //End Time
			
			/*
			//Print the HashSet
			Iterator<String> iter = hash.iterator();
			while (iter.hasNext())
			{
			   String string = iter.next();
			   System.out.println(string);
			}
			*/
			
			System.out.println();
			System.out.println("Time it took to add the txt file to a HashSet: " + (time2 - time1) + " nanoseconds"); //Resulting time
			
			//Close file
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
