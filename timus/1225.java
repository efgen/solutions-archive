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
  int n = in.nextInt();
  long[] w = new long[n+1], r = new long[n+1],bw = new long[n+1], br = new long[n+1];    
  w[1] = 1; r[1] = 1; bw[1] = 0; br[1] = 0;
  for (int i=2; i<=n; i++) {
	  bw[i] = w[i-1];
	  br[i] = r[i-1];
	  w[i] = r[i-1]+br[i-1];
	  r[i] = w[i-1]+bw[i-1];
  }
  out.print(w[n]+r[n]);
  in.close();  out.close();
}
}