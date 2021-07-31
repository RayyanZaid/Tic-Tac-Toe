
public class TicTacToe extends Methods{

	public static void main(String[] args) {
		
		boolean isNotFinished = true;
		int counter = 0;
		
		
		setUserName1();
		setUserName2();
		char[][] exampleBoard = {
				   {'1', '|', '2', '|', '3'},
				   {'-', '+', '-', '+', '-'},                       
				   {'4', '|', '5', '|', '6'},
				   {'-', '+', '-', '+', '-'},
				   {'7', '|', '8', '|', '9'}
				   };
		
		for(char[] row : exampleBoard)
		{
			for(char col : row)
			{
				System.out.print(col);
			}
			System.out.println();
		}
		
		while(isNotFinished || counter == 9)
		{
		
		userInput();
		printBoard();
		
		if(winnerDeclaration().contains(player1))
		{
			isNotFinished = false;
			
		}
		System.out.println(winnerDeclaration());
		
		if(isNotFinished == false)
		{
			System.exit(1);
		}
		
		
		otherUserInput();
		printBoard();
		
		if(winnerDeclaration().contains(player2))
		{
			isNotFinished = false;
		}
		System.out.println(winnerDeclaration());
		
		if(isNotFinished == false)
		{
			System.exit(1);
		}
		
		
		counter++; 
		
		
		}
		
		
	}

}
