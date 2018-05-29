import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/*
Name: Kyle Pamintuan
Date: 10-1-15
Purpose: This program retrieves multiple memos from a chosen file
Inputs: User's choice to read more memos or end program
Outputs: Memos  
*/

public class Main 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Initialize java window file chooser
		JFileChooser chooser = new JFileChooser();
		
		//If user chooses a file...
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			//Initialize variables
		   File selectedFile = chooser.getSelectedFile(); //Get selected file
		   Scanner reader = new Scanner(selectedFile);  //Reader for selected file
		   Scanner reader2 = new Scanner(System.in);  //Reader for user input
		   boolean end = false; //On/Off switch
		   
		   //While there is still more data on the selected file & while user still wants to continue reading memos...
		   while (reader.hasNext() && !end)
			{
			   //Initialize lines from the memo
				String topic = reader.nextLine();
				String date = reader.nextLine();
				String message = reader.nextLine();
				String space1 = reader.nextLine();
				String margin = reader.nextLine();
				String space2 = reader.nextLine();
				
				//Print the full memo
				System.out.println(topic);
				System.out.println(date);
				System.out.println(message);
				System.out.println(space1);
				System.out.println(margin);
				System.out.println(space2);
				
				//While there is still more data on the selected file...
				if (reader.hasNextLine()) 
	            { 
					//Ask if user still wants to continue reading memos...
					System.out.println("***** View next memo? Type 'y' is yes. Otherwise, program will end. *****"); 
					String string = reader2.nextLine(); 
					
					//If yes, continue. Otherwise, end program
					if(string.equals("y"))
						end = false;
					else
						end = true;
	            }
			}
		   
		   //Close selected file scanner
		   reader.close();
		}
	}

}
