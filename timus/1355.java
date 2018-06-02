import java.io.*;
import java.util.*;
import java.math.*;



public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}



public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  int test = in.nextInt();
  while (test-->0) {
	  int a = in.nextInt(), b = in.nextInt();
	  if (b%a>0) {out.println(0); continue;}
	  int x = b/a, p = 2, res = 1;
	  while (x>1) 
		  if (x%p == 0 ) {x /= p; res++;} else 
			  if (p*p<x) p++; else p = x;
	  out.println(res); 	  
  }
  in.close();  out.close();
}

}