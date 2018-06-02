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
  String s = "";
  TreeSet t = new TreeSet();
  while (s.compareTo("#")!=0){
	  s = in.nextLine();
	  StringTokenizer st = new StringTokenizer(s," -");
	  while (st.hasMoreTokens()) t.add(st.nextToken());
  }
  out.print(t.size()-2);
  out.flush(); 
}


}