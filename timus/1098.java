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
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  // int n = in.nextInt();
  // int k = in.nextInt(); 
  String s = "";
  while (in.hasNextLine()) s+=in.nextLine();
  int n = s.length();
  int k = 1999;
  int r = 0;
  for (int i=1; i<=n; i++)
	  r = (r+k) % i;
 // out.print(r);
  if (s.charAt(r)=='?') out.print("Yes"); else
	  if (s.charAt(r)==' ') out.print("No"); else 
		  out.print("No comments");
  in.close(); out.close();
}

}


