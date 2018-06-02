import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
public static void main(String[] args) throws IOException {	new Main().run();}
Scanner in;
PrintWriter out;


void run() throws IOException {
  boolean debug = false;
  if (debug) {
	  in = new Scanner(new File("input.txt"));
	  out = new PrintWriter(new File("output.txt"));	  
  } else {
	  in = new Scanner(System.in);
	  out = new PrintWriter(System.out);	  
  } 
  int n = in.nextInt(), k = n; 
  double res = 0;
  while (k-->0) res += in.nextDouble();
  res /= n;
  out.printf(Locale.CHINA,"%1.6f", res);
  if (debug) {in.close(); out.close();} else out.flush(); 
}


}