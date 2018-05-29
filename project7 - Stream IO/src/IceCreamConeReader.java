import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Name: Kyle Pamintuan
Date: 11-12-15
Purpose: To show the use of Stream I/O
Inputs: User input - Number choice of ice cream flavor
Outputs: Details of the ice cream cone chosen by the user
*/

public class IceCreamConeReader 
{
	public static void main(String[] args)
    {
		try
		{	
			//Read objects from the file and place them in a holder list
			FileInputStream fis = new FileInputStream("IceCreamCones.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Object> cones = new ArrayList<Object>();
			Object result1 = ois.readObject();
			Object result2 = ois.readObject();
			Object result3 = ois.readObject();
	        cones.add(result1);
	        cones.add(result2);
	        cones.add(result3);
	        
	        /*
	        //Print all ice cream cones
	        for (int i = 0; i < cones.size(); i++)
            {
	        	int number = i + 1;
	        	System.out.println("Cone " + number + ": ");
	        	System.out.println(cones.get(i).toString());
            }
            */
	        
	        //Ask user which flavor of ice cream they want and display the appropriate cone
	        Scanner input = new Scanner(System.in);
	        System.out.println("What flavor ice cream?");
	        System.out.println("1. Chocolate");
	        System.out.println("2. Vanilla");
	        System.out.println("3. Strawberry");
	        int choice = input.nextInt();
        	System.out.println(cones.get(choice - 1).toString());
		    
			//Close file
			ois.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
		catch (InputMismatchException e) 
		{
			e.printStackTrace();
		}
    }
}
