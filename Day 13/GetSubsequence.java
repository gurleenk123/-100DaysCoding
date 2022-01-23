// 1. You are given a string str.
// 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
// Use sample input and output to take idea about subsequences.
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    ArrayList< String> res = gss(str);
    System.out.println(res);

    }

    public static ArrayList<String> gss(String str) 
    {
        if (str.length() == 0) {
      ArrayList< String> base = new ArrayList< >();           
      base.add("");
      return base;
    }
    char ch = str.charAt(0);                                     
                                  

    ArrayList< String> rres = gss(str.substring(1));                            
    ArrayList< String> mres = new ArrayList< >();                   
    for (String val : rres) {
      mres.add("" + val);                                       
    }
    for (String val : rres) {
      mres.add(ch + val);                                       
    }

    return mres;  
    }

}
