import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/*
Name: Kyle Pamintuan
Date: 10-27-15
Purpose: To show the use of Generic classes
Inputs: 10 boxes: includes box coordinates x, y (for position) & box width, height (for size)
Outputs: list of boxes in area measurements in sorted order & largest box out of the list
*/

public class Box extends Measurable
{
	private int x;
	private int y;
	private int height;
	private int width;
	private static ArrayList<Box> boxes = new ArrayList<Box>();

    public Box()
    {
    	x = 0;
    	y = 0;
    	height = 0;
    	width = 0;
    }
    
    public Box(int x, int y, int w, int h)
    {
    	this.x = x;
    	this.y = y;
    	height = h;
    	width = w;
    }
    
    
    public double getMeasure() 
    {
        double area = width * height;
        return area;
    }

    public static void main(String[] args)
    {
    	//Create boxes & sort them in order from least to greatest w/ respect to their area measurements
        Box b = new Box();
        boxes.add(new Box(200, 200, 70, 85));
        boxes.add(new Box(0, 0, 10, 20));
        boxes.add(new Box(400, 400, 233, 451));
        boxes.add(new Box(600, 600, 131, 149));
        boxes.add(new Box(50, 50, 25, 35));
        boxes.add(new Box(100, 100, 45, 55));
        boxes.add(new Box(1115, 1127, 387, 76));
        boxes.add(new Box(1550, 1780, 139, 188));
        boxes.add(new Box(2000, 2000, 678, 988));
        boxes.add(new Box(2250, 2670, 334, 458));
        Collections.sort(boxes);
        
        //Print list of boxes(in area measurements)
        System.out.println("List of Boxes (area measurements):");
        for(int i = 0; i < boxes.size(); i++)
        {
        	double area = 0;
            area = boxes.get(i).width * boxes.get(i).height;
            System.out.println(area);
        }
        
        //Print the largest box of the list
        System.out.println();
        System.out.println("Largest Box:");
        System.out.println((Measurable.getLargest(boxes)));
    }
}