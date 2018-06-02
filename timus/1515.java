import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}
long nextInt() throws IOException {
	in.nextToken();
	return (long)in.nval;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  out = new PrintWriter(System.out);
  long n = nextInt();
  long res = 0;
  while (n-->0) {
	  long x = nextInt();
	  if (x<=res+1) res = res+x; else break;
  }
  out.print(res+1);
  out.close();
}

}

