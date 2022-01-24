public class PrintMazePath 
{
	

	public static void main(String[] args)
	{
		
		//printPath(1,1,2,2,"");
		printPathwithJumps(1,1,2,2,"");

	}

	private static void printPath(int sr, int sc, int dr, int dc,String ans) 
	{
		if (sr > dr || sc > dc) {
		      return;
		    }
		if (sr == dr && sc == dc) 
		{                              
		     
		     System.out.println(ans);
		     return;
		}
		//horizontal move
	    	printPath(sr,sc+1,dr,dc,"h"+ans);
	    	
	    //for vertical we move by row
	    	printPath(sr+1,sc,dr,dc,"v"+ans);
	
	}
	
	public static void printPathwithJumps(int sr, int sc, int dr, int dc,String ans)
	{
		if (sr == dr && sc == dc) 
		{                              
		      System.out.println(ans);
		      return;
		}
		
		for(int hm=1;hm <= dc-sc;hm++)
		{
			printPathwithJumps(sr,sc+hm,dr,dc,"h" + hm + ans);
			
		}
		for(int vm=1;vm <= dr-sr;vm++)
		{
			printPathwithJumps(sr+vm,sc,dr,dc,"v" + vm + ans);
			
			
		}

		for(int dm=1;dm <= dc-sc && dm <= dr-sr;dm++)
		{
			printPathwithJumps(sr + dm, sc + dm, dr, dc,"d" + dm + ans);
			
		}
	}

}
