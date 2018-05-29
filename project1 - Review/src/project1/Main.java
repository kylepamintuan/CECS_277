package project1;

/*
Kyle Pamintuan
Cecs 277
9/15/15
Project 1: ArrayList (Game of War)
*/

import java.util.*;

public class Main 
{

	public static void main(String[] args) 
	{
		//Create ArrayLists
		List<String> deck = new ArrayList<String>();
	    List<String> player1 = new ArrayList<String>();
	    List<String> player2 = new ArrayList<String>();
	    List<String> pile = new ArrayList<String>(); //Array for cards at War
	    
	    //Create Deck
	    String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
	    for(int i = 0; i < 4; i++)
    	{        
    		for(int j = 2; j <= 10; j++)
    		{   
    			deck.add(j + " of " + suit[i]);
    		}
    		deck.add("Jack of " + suit[i]);
            deck.add("Queen of " + suit[i]);
            deck.add("King of " + suit[i]);
            deck.add("Ace of " + suit[i]);
    	}
	    
	    //Shuffle Deck
	    Collections.shuffle(deck);
	    
	    //Split Deck
	    for(int i = 0; i< 26;i++)
        {   
	    	player1.add(deck.get(i));
        }
	    for(int  i = 26; i < 52; i++)
	    {
	    	player2.add(deck.get(i));
	    }
        
	    //Begin Game
	    System.out.println("========================= Game Of War Begins! =========================");
    	System.out.println();
	    while (true)
	    {	
	    	char[] rank = new char[3]; //Array to store ranks (the first character of every card)
	    	int[] value = new int[14]; //Array to give all ranks a value
	    	
	    	int counter = 0;//This counts cards being moved to pile
	    	
	    	for(int i = 1; i <= 26; i = i + 4)
	    	{
	    		rank[1] = player1.get(0).charAt(0);
	    		rank[2] = player2.get(0).charAt(0);
	    		
	    		
	    		for (int j = 1; j <= 2; j++)
	    		{
	    			if(rank[j] == 'J')
	    			{
	    				value[j] = 10;
	    			}
	    			else if(rank[j] == 'Q')
	    			{
	    				value[j] = 11;
	    			}
	    			else if(rank[j] == 'K')
	    			{
	    				value[j] = 12;
	    			}
	    			else if(rank[j] == 'A')
	    			{
	    				value[j] = 13;
	    			}
	    			else
	    			{
	    				value[j] = Character.getNumericValue(rank[j]) - 1;
	    			}
	    		}
	    		
	    		//Prints both players' card at play
	    		System.out.println("Player 1 plays " +  player1.get(0));
	    		System.out.println("Player 2 plays " +  player2.get(0));
	    		
	    		//Announces winner of a Round
	    		//Gives all appropriate cards to the winner and adds them to the bottom of the winner's deck
	    		if(value[1] > value[2])
	    		{
	    			System.out.println("Player 1 Wins the Round!");
	    			System.out.println();
	    			player1.add(player1.get(0));
	    			player1.add(player2.get(0));
	    			player1.remove(0);
	    			player2.remove(0);
	    			
	    			if(i != 1) //Checks for a War
	    			{
	    				for(int j = 0; j < counter; j++)
	    				{
	    					player1.add(pile.get(0));
	    					pile.remove(0);
	    				}
	    			}
	    			
	    			break;//Ends the round
	    		}
	    		else if(value[1] < value[2])
	    		{
	    			System.out.println("Player 2 Wins the Round!");
	    			System.out.println();
	    			player2.add(player2.get(0));
	    			player2.add(player1.get(0));
	    			player2.remove(0);
	    			player1.remove(0);
	    			
	    			if(i != 1) //Checks for a War
	    			{
	    				for(int j = 0; j < counter; j++)
	    				{
	    					player2.add(pile.get(0));
	    					pile.remove(0);
	    				}
	    			}
	    			
	    			break; //Ends the round
	    		}
	    		//If both players' cards are equal ranks, a War begins!
    			else
    			{
    				System.out.println("----------------WAR!---------------");
    				
    				//Checks if both players have only one card left. If not, continue the war.
    				if(player1.size() != 1 && player2.size() != 1)
    				{
    					pile.add(player1.get(0));
    					player1.remove(0);
    					counter++;
    					
    					pile.add(player2.get(0));
    					player2.remove(0);
    					counter++;
    				}
    				
    				for(int j = 0; j < 3; j++)
    				{
    					//Checks if both players have only one card left. If so, the war will not continue.
    					if(player1.size() == 1 || player2.size() == 1)
    					{
    						break;
    					}
    					
    					//Each player places three faced-down cards with the name "xx"
    					System.out.println("Player 1 plays xx");
    					System.out.println("Player 2 plays xx");
    					
    					pile.add(player1.get(0));
    					player1.remove(0);
    					counter++;
    					
    					pile.add(player2.get(0));
    					player2.remove(0);
    					counter++;
    				}
    			}
    		}
	    	
	    	//End Game and Announce Winner
    		if(player2.isEmpty())
			{
				System.out.println("Game Over");
				System.out.println();
				System.out.println("****** PLAYER 1 WINS THE GAME! *****");
				
				break;
			}
			else if(player1.isEmpty())
			{
				System.out.println("Game Over");
				System.out.println();
				System.out.println("****** PLAYER 2 WINS THE GAME! *****");
				
				break;
			}
	    	}
	    }
	}
