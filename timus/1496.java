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
  TreeSet t = new TreeSet(), not = new TreeSet();
  
  int n = in.nextInt(); in.nextLine();
  while (n-->0) {
	  String s = in.nextLine();
	  if (t.contains(s)) 
		  if (!not.contains(s)){
			 not.add(s);
		     out.println(s);
		     } else ;
	  else t.add(s);
  }
  out.flush(); 
}


}