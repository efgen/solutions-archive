import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
public static void main(String[] args) throws IOException {	new Main().run();}
Scanner in;
PrintWriter out;


void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int kolv = in.nextInt();
  while (kolv-->0) {
	  long n = 2*(in.nextLong()-1);
	  long k = Math.round(Math.floor(Math.sqrt(n)));
	  if (k*(k+1)==n || (k-1)*k==n) 
	     out.print("1 "); else out.print("0 "); 
  }
  out.flush(); 
}


}