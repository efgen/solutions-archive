import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int B = in.nextInt();
  int R = in.nextInt();
  int Y = in.nextInt();
  int K = in.nextInt();
  int res = 1;
  while (K-->0) {
	  char c = in.next().charAt(0);
	  if (c=='B') res *= B; else
		  if (c=='R') res *= R; else res *= Y;
  }
  out.print(res);
  
  in.close(); out.close();  
}
}



