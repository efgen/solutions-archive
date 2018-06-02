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
  int L = in.nextInt();
  int n = in.nextInt();
  while (n-->0) {
	  int k = in.nextInt();
	  L = L-L%k;
  }
  if (L==0) out.print("YES"); else out.print("NO"); 
  in.close(); out.close();
}

}


