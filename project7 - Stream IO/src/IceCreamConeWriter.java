import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
Name: Kyle Pamintuan
Date: 11-12-15
Purpose: To show the use of Stream I/O
Inputs: None
Outputs: Write objects to the file IceCreamCones.bin
*/

public class IceCreamConeWriter 
{
	public static void main(String[] args)
    {
		try
		{	
			//Create ice cream cones
			AdvancedIceCreamCone cone1 = new AdvancedIceCreamCone(1, "chocolate", "wafer");
			AdvancedIceCreamCone cone2 = new AdvancedIceCreamCone(1, "vanilla", "sugar");
			AdvancedIceCreamCone cone3 = new AdvancedIceCreamCone(1, "strawberry", "waffle");
			
			//Add toppings for fun
			cone1.addToppings("captain crunch");
			cone1.addToppings("mochi");
			cone1.addToppings("granola");
			cone2.addToppings("kit kat");
			cone2.addToppings("coconut bits");
			cone2.addToppings("strawberry");
			cone3.addToppings("banana");
			cone3.addToppings("mango");
			cone3.addToppings("bacon");
			

			//Write objects to the file
			FileOutputStream fos = new FileOutputStream("IceCreamCones.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cone1);
			oos.writeObject(cone2);
			oos.writeObject(cone3);
			
			//Close file
			oos.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
    }
}
