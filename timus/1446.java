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
  int n = in.nextInt(); in.nextLine();
  Vector G = new Vector(), H = new Vector(), S = new Vector(), R = new Vector();
  while (n-->0) {
	  String name = in.nextLine();
	  String fuck = in.nextLine();
	  if (fuck.compareTo("Gryffindor")==0) G.add(name); else
	  if (fuck.compareTo("Hufflepuff")==0) H.add(name); else
	  if (fuck.compareTo("Slytherin")==0) S.add(name); else	  
	  if (fuck.compareTo("Ravenclaw")==0) R.add(name);   		  
  }
  
  out.println("Slytherin:");
  Iterator it = S.iterator();
  while (it.hasNext()) out.println((String)it.next());
  out.println();
  
  out.println("Hufflepuff:");
  it = H.iterator();
  while (it.hasNext()) out.println((String)it.next());
  out.println();
  
  out.println("Gryffindor:");
  it = G.iterator();
  while (it.hasNext()) out.println((String)it.next());
  out.println();
  
  out.println("Ravenclaw:");
  it = R.iterator();
  while (it.hasNext()) out.println((String)it.next());

  if (debug) {in.close(); out.close();} else out.flush(); 
}


}