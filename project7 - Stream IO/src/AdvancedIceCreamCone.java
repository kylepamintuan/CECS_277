import java.io.Serializable;
import java.util.*;

/* This class is used to model the properties and behaviors of an ice cream cone.
There are currently restriction on the construction of the cone: only one
flavor of ice cream is allowed and up to five toppings. You can only add scoops, you
cannot remove them. 
*/

public class AdvancedIceCreamCone implements Serializable
{
	public static final long serialVersionUID = 1L;
	private int numberOfScoops;
	private String flavor;
	private String typeOfCone;
	private ArrayList<String> toppings = new ArrayList<String>();

	//the default constructor creates a one scoop, vanilla ice cream cone using the regular type of cone and no toppings
	public AdvancedIceCreamCone() 
	{
		numberOfScoops = 1;
		flavor = "vanilla";
		typeOfCone = "regular";
	}
	
	//this constructor lets you create an ice cream code to your liking. It takes in three parameters
	public AdvancedIceCreamCone(int number,String flavor,String cone) 
	{
		numberOfScoops = number;
		this.flavor = flavor;
		typeOfCone = cone;
	}
	
	//this method returns the number of scoops in the cone
	public int getNumberOfScoops () 
	{
		return numberOfScoops;
	}
	
	//this method returns the ice cream flavor
	public String getFlavor() 
	{
		return flavor;
	}
	
	//this method returns the type of cone
	public String getTypeOfCone() 
	{
		return typeOfCone;
	}
	
	//this method allows you to add one scoop of ice cream at a time
	public void addScoop() 
	{
		numberOfScoops = numberOfScoops + 1;
	}
	
	//this method allows you to change the ice cream flavor
	public void setFlavor(String flavor) 
	{
			this.flavor = flavor;
	}
	
	//this method allows you to change the type of cone
	public void setTypeOfCone(String cone) 
	{
		typeOfCone = cone;
	}
	
	//this method allows you to add toppings
    public void addToppings(String topping) 
    {
		  toppings.add(topping);
	}

    //this method returns a String with a list of the toppings
	public ArrayList<String> getToppings () 
	{
		return toppings;
	}

	//this method overrides the inherited toString()
	public String toString() 
	{
		return ( "Flavor: " + flavor + " // Number of Scoops: " + numberOfScoops + 
				" // Type of Cone: " + typeOfCone + " // Toppings: " + getToppings());
	}

}
