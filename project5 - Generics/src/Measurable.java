import java.awt.Rectangle;
import java.util.ArrayList;

/*
Name: Kyle Pamintuan
Date: 10-27-15
Purpose: To show the use of Generic classes
Inputs: 10 boxes: includes box coordinates x, y (for position) & box width, height (for size)
Outputs: list of boxes in area measurements in sorted order & largest box out of the list
*/

public abstract class Measurable<T extends Measurable> implements Comparable<Measurable>
{
	abstract double getMeasure();
	
	public int compareTo(Measurable o)
    {
    	if(this.getMeasure() == o.getMeasure())
    		return 0;
    	else if(this.getMeasure() < o.getMeasure())
    		return -1;
    	else
    		return 1;
    }

    public static <T extends Measurable<T>> double getLargest(ArrayList<T> objects)
    {
        double largest = objects.get(0).getMeasure();
        for(int i = 0; i < objects.size(); i++)
        {
        	double other = objects.get(i).getMeasure();
            if(other > largest)
                largest = other;
        }
        return largest;
    }

}