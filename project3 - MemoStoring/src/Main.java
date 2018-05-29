import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/*
Name: Kyle Pamintuan
Date: 10-1-15
Purpose: This program creates a text file and allows the user to write & store multiple memos
		 on that file if they so desire.
Inputs: Memos & user's choice to continue
Outputs: Writes memos onto "Memos.txt"  
*/

public class Main 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Initialize variables
		String topic;
		Date date = new Date();
		String message;
		Scanner reader = new Scanner(System.in);
		File outputFile = new File("Memos.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		String string; //On/Off switch for the program
		
		System.out.println("***** Create memo? Type 'y' is yes. Otherwise, program will end. *****");
		string = reader.nextLine(); //Get user input
		System.out.println();
		
		//While user still wants to continue creating memos...
		while (string.equals("y")) 
        {  
			//Memo topic
        	System.out.println("Memo Topic:"); 
	        topic = reader.nextLine();	//get user input and then...
	        writer.println("Memo Topic: " + topic); //write that onto "Memos.txt"
	        
	        //Date Stamp
	        writer.println("Date & Time: " + date.toString());
	        
	        //Memo message
	        System.out.println("Memo Message:");
	        message = reader.nextLine();
	        writer.println("Memo Message: " + message);
	        
	        //Spaces and margins for a better looking output
	        System.out.println();
	        System.out.println("-------------------------------------");
	        System.out.println();
	        writer.println();
	        writer.println("-------------------------------------");
	        writer.println();
	        
	        System.out.println("***** Create memo? Type 'y' is yes. Otherwise, program will end. *****");
			string = reader.nextLine();
			System.out.println();
       }
		//Close system input scanner
		reader.close();
		//Close "Memos.txt" writer
		writer.close();
	}
}
