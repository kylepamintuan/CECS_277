import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Name: Kyle Pamintuan
Date: 11-19-15
Purpose: To show the use of Threads
Inputs: User input - number of racers
Outputs: Race details
*/

class MarioKart8 implements Runnable 
{
		//Initialize variables
	   private Thread t;
	   private String threadName;
	   private int threadDelay;
	   private final int distance = 100;	//Total distance of the race
	   private int racersDistance;		//Keeps track of the racers progress
	   private int threadSpeed;
	   public static int place = 1;	//Keeps track of the placing of all racers that cross the finish line
	   public static int totalDistance;	//Keeps track of the total distance w.r.t. the number of racers
	   public static int somecounter;	//Keeps track of the number of racers
		   
	   //Default Constructor
	   MarioKart8()
	   {
		   threadName = "";
		   threadDelay = 0;
		   racersDistance = 0;
		   threadSpeed = 0;
		   totalDistance = 0;
		   somecounter = 0;
	   }
	   
	   //Parameterized Constructor
	   MarioKart8(String name, int speed, int delay)
	   {
	       threadName = name;
	       threadSpeed = speed;
	       threadDelay = delay;
	       somecounter++;
	   }
	   
	   //Override start() method from the Threads class
	   public void start ()
	   {
         t = new Thread (this, threadName);
         t.start ();
         System.out.println(threadName + " start!");
	   }
	   
	   //This method gets called after start() is called
	   public void run() 
	   {
		   while(racersDistance < distance) //while racer is still in the race...
		   {
			  try 
			  { 
				//Let the thread sleep
		        Thread.sleep(threadDelay);
			  } 
			  catch (InterruptedException e) 
			  {
			     System.out.println("Thread " +  threadName + " interrupted");
			  }
			  racersDistance += threadSpeed;	//Increase the racer's progress in the race
			  
			  //Laps
			  if(racersDistance == 20)
				  System.out.println(threadName + "     Lap 1 Complete");
			  else if(racersDistance == 40)
				  System.out.println(threadName + "     Lap 2 Complete");
			  else if(racersDistance == 60)
				  System.out.println(threadName + "     Lap 3 Complete");
			  else if(racersDistance == 80)
				  System.out.println(threadName + "     Lap 4 Complete");
		   }
		   
		   //After thread(racer) is finished, print message and include their placing at the end of the race  
		   System.out.println(threadName + " finished!			Place:" + place);
		   place++;
		   totalDistance += 100;
		   racersDistance = 0;	//Reset racer's distance
		   
		   //If all racers have finished, print message to notify the end of the race
		   if(totalDistance == (somecounter * 100))
		   {
			   System.out.println("ALL RACERS FINISHED!");
		   }
		   
   }
	   
	   public static void main(String args[]) 
	   {
		   try
			{
			   ArrayList<String> Racers = new ArrayList<String>();	//Holder list for the characters
		       File inputFile = new File("MarioKartCharacters.txt");	//Open file
		       Scanner in = new Scanner(inputFile);		//Reader for the file
		       
		       //Read the names off the file and add them to the list
		       while(in.hasNext())
		       {
		    	   String character = in.nextLine();
		    	   Racers.add(character);
		       }
		       
		       //Shuffle the list
		       Collections.shuffle(Racers);
		       
		       //Title for the race
			   System.out.println("========== Mario Kart 8 ==========");
			   System.out.println();
			   
			   //Ask user how many racers they want and get their input
			   System.out.println("How many racers desired? (minimum: 3 / maximum: 24)");
			   Scanner input = new Scanner(System.in);
			   int number = input.nextInt();
			   
			   if (number >= 3 && number <= 24)		//If user inputs the appropriate number of racers, we can start the race
			   {
				   //Start the Race
				   System.out.println();
				   System.out.println("GO!");
				   
				   for(int i = 1; i <= number; i++)
				   {
					   //Give each racer a name
					   String name = Racers.get(i - 1);
					   
					   //Random sleep factor for each racer
					   Random rand = new Random();
					   int n = rand.nextInt(50);
					   
					   //Random speed factor for each racer
					   Random rand2 = new Random();
					   int n2 = rand2.nextInt(10);
					   
					   //Create racers
					   MarioKart8 raceri = new MarioKart8("Racer #" + i + " - " + name, n2, n);
					   raceri.start();		//Start their threads
				   }
				   
			   }
			   else		//Cannot start the race because user entered the invalid number of racers
			   {
				   //Error message
				   System.out.println();
				   System.out.println("ERROR!: Must enter a number from 3 to 24");
			   }
			   
			   //Close the file
		       in.close();
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