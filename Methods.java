import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Methods  {
	
	// instance variables 
	static char[][] tic = { 
			   {' ', '|', ' ', '|', ' '},
			   {'-', '+', '-', '+', '-'},                       
			   {' ', '|', ' ', '|', ' '},
			   {'-', '+', '-', '+', '-'},
			   {' ', '|', ' ', '|', ' '}
			   };

	
	
	static String player1;
	static String player2; 
	
	static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
	
	//methods
	
	public static void printBoard()
	{
		
					for(char[] row : tic)
						{
							for(char col : row)
								{
									System.out.print(col);
								}
							System.out.println();
						}
	}
	
	public static void setUserName1()
	{
		Scanner user1 = new Scanner(System.in);
		System.out.print("Player 1, please enter your name: ");
		player1 = user1.nextLine();
		
	}
	
	public static void setUserName2()
	{
		Scanner user2 = new Scanner(System.in);
		System.out.print("Player 2, please enter your name: ");
		player2 = user2.nextLine();
		
	}
	
	
	public static void userInput()
	{
		Scanner turn = new Scanner(System.in);
		System.out.println(player1 + " Enter Position here (1-9): ");
		int position = turn.nextInt();
		while(player1Positions.contains(position) || player2Positions.contains(position))
			{
				System.out.print("Enter Another Position");
				position = turn.nextInt();
			}
		
		int count = 0;
		
		for(int i = 0; i < 5; i+=2)
		{
			for(int j = 0; j<5; j+=2)
			{
				count++;
				if(position == count)
				{
					tic[i][j] = 'X';
					player1Positions.add(count);
				}
				
			}
		}
	}
	public static void otherUserInput()
	{
		{
			Scanner turn = new Scanner(System.in);
			System.out.println(player2 + " Enter Position here (1-9): ");
			int position = turn.nextInt();
			while(player1Positions.contains(position) || player2Positions.contains(position))
			{
				System.out.print("Enter Another Position");
				position = turn.nextInt();
			}
			
			int count = 0;
			
			for(int i = 0; i < 5; i+=2)
			{
				for(int j = 0; j<5; j+=2)
				{
					count++;
					if(position == count)
					{
						tic[i][j] = 'O';
						player2Positions.add(count);
					}
					
				}
			}	
		}
		
		
	
	}
	public static String winnerDeclaration()
	{
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winningConditions = new ArrayList<List>();
		
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		for(List l : winningConditions)
		{
			if(player1Positions.containsAll(l))
			{
			return "Congratulations " + player1 + " you won!";
			}
			else if(player2Positions.containsAll(l))
			{
				return "Congratulations " + player2 + " you won!";
			}
			else if(player1Positions.size() + player2Positions.size() == 9)
			{
				return "TIE. You both suck";
			}
			
		}
		return "";
			
	}

	
	
	
	
	
	
	
	
	
	
	
}
