// 1.You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
import java.util.*;

public class GetMazePath 
{
	

	public static void main(String[] args)
	{
	
	   
	    ArrayList< String> paths = getMazePaths(1, 1, 3,3);
	    System.out.println(paths);
		

	}

	//sr=source row ,sc=source column
	//dr=destination row, dc=destination column
	private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) 
	{
		//base case
		
		if (sr == dr && sc == dc) 
		{                              
		      ArrayList< String> bres = new ArrayList< >();
		      bres.add("");
		      return bres;
		}
		
		ArrayList< String> hpaths = new ArrayList< >();     //horizontal paths      
	    ArrayList< String> vpaths = new ArrayList< >();     //vertical paths
	    
	    
	    //for horizontal move we will move by column
	    if(sc < dc)
	    {
	    	hpaths=getMazePaths(sr,sc+1,dr,dc);
	    	
	    }
	    
	    //for vertical we move by row
	    if(sr < dr)
	    {
	    	vpaths=getMazePaths(sr+1,sc,dr,dc);
	    }
	    
	    ArrayList< String> totalpaths = new ArrayList< >();
	    
	    for(String ans : hpaths)
	    {
	    	totalpaths.add("h"+ans);
	    }
	    
	    for(String ans : vpaths)
	    {
	    	totalpaths.add("v"+ans);
	    }
	    
	return totalpaths;
		
	}



}
