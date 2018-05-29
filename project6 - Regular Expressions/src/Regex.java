import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Name: Kyle Pamintuan
Date: 10-27-15
Purpose: To show the use of Regular Expressions
Inputs: scrabble.txt file
Outputs: words based on regular expression patterns & pattern #5 words are written to an output file called words.txt
*/

public class Regex 
{	
	public static void main(String[] args)
    {
		try
		{
			//Initialize variables
	       File inputFile = new File("scrabble.txt");	//open scrabble.txt
	       File outputFile = new File("words.txt");		//open words.txt
	       Scanner in = new Scanner(inputFile);		//reader for an input text file (scrabble.txt)
	       PrintWriter writer = new PrintWriter(outputFile);	//writer for an output text file (words.txt)
	       Scanner userInput = new Scanner(System.in);	//reader for user input
	       int word_counter = 0; 	//word counter
	       
	       //Title and List of Regex Project Patterns
	       System.out.println("===== Regular Expressions =====");
	       System.out.println();
	       System.out.println("Choose an option of words to return from scrabble.txt");
	       System.out.println("1. All of the words with two z's in a row");
	       System.out.println("2. All of the words with two vowels in a row");
	       System.out.println("3. All of the words with more than two vowels in them");
	       System.out.println("4. All of the words with two x's in them");
	       System.out.println("5. All of the words starting with 'Q' not followed by a 'U'");
	       int option = 0;
	       option = userInput.nextInt();
	       
	       if (option == 1) //Search all of the words with two z's in a row. (385 words)
	       {
	    	   System.out.println();
	    	   
	    	   while(in.hasNext())
		       {
		    	   String string = in.nextLine();
		    	   Pattern pattern2 = Pattern.compile("z{2}");
		    	   Matcher matcher2 = pattern2.matcher(string);
		    	   if(matcher2.find() == true)
		    	   {
		    		   System.out.println(string);
		    		   word_counter++;
		    	   }
		       }
		       System.out.println("This list contains: " + word_counter + " words");
	       }
	       else if (option == 2) //Search all of the words with two vowels in a row. (63864 words)
	       {
	    	   System.out.println();
	    	   
	    	   while(in.hasNext())
		       {
		    	   String string = in.nextLine();
		    	   Pattern pattern2 = Pattern.compile("[aeiou]{2}");
		    	   Matcher matcher2 = pattern2.matcher(string);
		    	   if(matcher2.find() == true)
		    	   {
		    		   System.out.println(string);
		    		   word_counter++;
		    	   }
		       }
		       System.out.println("This list contains: " + word_counter + " words");   
	       }
	       else if (option == 3) //Search all of the words with more than two vowels in them. (132420 words)
	       {
	    	   System.out.println();
	    	   
	    	   while(in.hasNext())
		       {
		    	   String string = in.nextLine();
		    	   Pattern pattern2 = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou]");
		    	   Matcher matcher2 = pattern2.matcher(string);
		    	   if(matcher2.find() == true)
		    	   {
		    		   System.out.println(string);
		    		   word_counter++;
		    	   }
		       }
		       System.out.println("This list contains: " + word_counter + " words");
	       }
	       else if (option == 4) //Search all of the words with two x's in them. (16 words)
	       {
	    	   System.out.println();
	    	   
	    	   while(in.hasNext())
		       {
		    	   String string = in.nextLine();
		    	   Pattern pattern2 = Pattern.compile(".*x.*x");
		    	   Matcher matcher2 = pattern2.matcher(string);
		    	   if(matcher2.find() == true)
		    	   {
		    		   System.out.println(string);
		    		   word_counter++;
		    	   }
		       }
		       System.out.println("This list contains: " + word_counter + " words");   
	       }
	       else if (option == 5) //Search all of the words starting with 'Q' not followed by a 'U'. For this one, write these words to a file. (25 words)
	       {
	    	   System.out.println();
	    	   
	    	   while(in.hasNext())
		       {
		    	   String string = in.nextLine();
		    	   Pattern pattern2 = Pattern.compile("^[q][^u]");
		    	   Matcher matcher2 = pattern2.matcher(string);
		    	   if(matcher2.find() == true)
		    	   {
		    		   System.out.println(string);
		    		   writer.println(string);
		    		   word_counter++;
		    	   }
		       }
		       System.out.println("This list contains: " + word_counter + " words");
	       }
	       else
	       {
	    	   System.out.println();
	    	   System.out.println("ERROR! Must enter a number from 1-5");
	       }
	       
	       in.close();
	       writer.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();
		}
    }
}
