import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
Name: Kyle Pamintuan
Date: 10-15-15
Purpose: To show how Maps work
Inputs: text file containing Scrabble guidelines and text file containing some words(starting with 'q')
Outputs: words from file1.txt and their point value based on Scrabble guidelines
*/

public class HashMaps
{
	public static void main(String[] args) 
	{
		try 
		{
			//Initialize Variables
			Map<String, Integer> scrabble = new HashMap<String, Integer>(); //HashMap <Keys = letter, Values = points>
			File inputFile2 = new File("file2.txt");
			File inputFile = new File("file1.txt");
			Scanner in = new Scanner(inputFile);
			Scanner in2 = new Scanner(inputFile2);
			ArrayList<String> words = new ArrayList<String>(); //ArrayList to store words from file1.txt
			
			//Add the keys and values into the HashMap
			while(in2.hasNext())
			{
				String letter = in2.next();
				int points = in2.nextInt();
				scrabble.put(letter, points);
			}
			
			//Add words from file.txt to the ArrayList
			while(in.hasNext())
			{
				String string = in.nextLine();
				words.add(string);
			}
			
			ListIterator<String> cursor = words.listIterator(); //Arraylist iterator
			Set<String> keySet = scrabble.keySet(); //get the HashMap keySet
			int totalPoints = 0; //point value holder
			
			//Get total points for each word in the Arraylist & print it
			while(cursor.hasNext())
			{
				String s = cursor.next();
				for (int i = 0; i < s.length(); i++) //check all letters in the word and add up the points
				{
				    char c = s.charAt(i);
				    char charToUppercase = Character.toUpperCase(c);
				    String charToString = Character.toString(charToUppercase);
				    for(String key : keySet) //go through all the letters in the keySet
					{
				    	int value = scrabble.get(key);
				    	if(charToString.equals(key)) //if that key is equal to the corresponding letter, add its point value to the total
				    	{
				    		totalPoints = totalPoints + value;
				    	}
					}
				}
				System.out.println(s + ": " + totalPoints + " points");
				totalPoints = 0; //each word gets their own total. Here, we reset the total between words.
			}
			
			/*
			//Print HashMap that contains every letter in the alphabet and their point value based on Scrabble guidelines
			Set<String> keySet = scrabble.keySet();
			for(String key : keySet)
			{
				Integer value = scrabble.get(key);
				if(value == 1)
					System.out.println(key + ": " + value + " point");
				else
					System.out.println(key + ": " + value + " points");
			}
			*/
			
			in.close();
			in2.close();
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}
