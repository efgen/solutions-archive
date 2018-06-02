import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

	BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
 // in = new Scanner(System.in); in.useLocale(Locale.US);  
	 in = new BufferedReader(new InputStreamReader(System.in));
  out = new PrintWriter(System.out);
  String s = in.readLine();  
  int max = 1, sum = 0, c = 0;
  for (int p=0; p<s.length(); p++) {	  
	  if (Character.isDigit(s.charAt(p))) c = s.charAt(p)-'0'; else c = s.charAt(p)-'A'+10;
	  if (c>max) max = c;
	  sum += c;	  
  }
  for (max++; max<=36; max++) 
	  if (sum%(max-1)==0) break;  
  if (sum%(max-1)==0) out.print(max); else out.print("No solution.");
 // in.close(); 
  out.close();
}

}


