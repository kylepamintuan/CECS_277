import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
Name: Kyle Pamintuan
Date: 10-15-15
Purpose: To test time efficiency with Sets
Inputs: text file of the novel "Alice in Wonderland"
Outputs: time it takes to add words from the text file to a TreeSet, times of operations
*/

public class TreeSets 
{
	public static void main(String[] args)
	{	
		try 
		{
			//Timer for efficiency timing
			Date today = new Date();
			long time1, time2;
			
			//Initialize variables
			Set<String> tree = new TreeSet<String>();
			File inputFile = new File("alice13a.txt"); //open file
			Scanner in = new Scanner(inputFile);
			
			//Add words from alice13a.txt to the TreeSet
			time1 = System.nanoTime(); //Start time
			while (in.hasNext())
			{
				String data = in.nextLine();
				tree.add(data);
			}
			time2 = System.nanoTime(); //End time
			
			/*
			//Print the TreeSet
			Iterator<String> iter = tree.iterator();
			while (iter.hasNext())
			{
			   String string = iter.next();
			   System.out.println(string); 
			}
			*/
			
			System.out.println();
			System.out.println("Time it took to add the txt file to a TreeSet: " + (time2 - time1) + " nanoseconds"); //Resulting time
			
			//close file
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
}
