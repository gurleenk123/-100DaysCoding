// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps
//vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception 
    {
         Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    ArrayList< String> paths = getMazePaths(1, 1, n, m);
    System.out.println(paths);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if (sr == dr && sc == dc) 
		{                              
		      ArrayList< String> bres = new ArrayList< >();
		      bres.add("");
		      return bres;
		}
		
		ArrayList< String> totalpaths = new ArrayList< >();
		
		//hm = horizontal moves
		for(int hm=1;hm <= dc-sc;hm++)
		{
			ArrayList<String> hpaths=getMazePaths(sr,sc+hm,dr,dc);
			for(String hpath: hpaths)
			{
				totalpaths.add("h" + hm + hpath);
				
			}
		}
		//vm = vertical moves
				for(int vm=1;vm <= dr-sr;vm++)
				{
					ArrayList<String> vpaths=getMazePaths(sr+vm,sc,dr,dc);
					for(String vpath: vpaths)
					{
						totalpaths.add("v" + vm + vpath);
						
					}
				}
		
		//diagonal move
				for(int dm=1;dm <= dc-sc && dm <= dr-sr;dm++)
				{
					ArrayList< String> dpaths = getMazePaths(sr + dm, sc + dm, dr, dc);
					for(String dpath:dpaths)
					{
						totalpaths.add("d" + dm + dpath);
					}
				}
		
		return totalpaths;
    }

}
