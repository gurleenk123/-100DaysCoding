// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions

public class Nqueens {

	public static void main(String[] args) {
	
		 int[][] chess = new int[4][4];
		 printNQueens(chess, "", 0);

	}
	public static void printNQueens(int[][] chess, String qsf, int row) 
	{
	    if (row == chess.length) 
	    {
	      System.out.println(qsf + ".");
	      return;
	    }
	    for (int col = 0; col < chess.length; col++) 
	    {
	      if (chess[row][col] == 0 && isQueenSafe(chess, row, col) == true) 
	      {
	        chess[row][col] = 1;
	        printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
	        chess[row][col] = 0; //edge post condition
	      }
	    }
	    
	  }
	 public static boolean isQueenSafe(int[][] chess,int row, int col)
	 {
		 
		 //diagonally left
		 for (int i = row - 1, j = col - 1;i >= 0 && j >= 0; i--, j--)
		 {
				 if (chess[i][j] == 1)
				 {
				 return false;
				 }
		 }
		 
		 //vertically upwards
		 for (int i = row - 1, j = col; i >= 0; i--) 
		 {
			 if (chess[i][j] == 1) 
			 {
			 return false;
			 }
		 }
		 
		 //diagonally right
		 for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++)
		 {
				 if (chess[i][j] == 1)
				 {
				 return false;
				 }
		 }
		 
		 //left side
		 for (int i = row, j = col - 1; j >= 0; j--)
		 {
			 if (chess[i][j] == 1)
			 {
			 return false;
			 }
		 }


         return true;
      }

}
