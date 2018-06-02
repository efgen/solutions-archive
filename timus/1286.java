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

long gcd(long a, long b) {
	if (b==0) return a; else return gcd(b,a%b);
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  long p = Math.abs(in.nextLong());
  long q = Math.abs(in.nextLong());
  long x = in.nextLong();
  long y = in.nextLong();
  x = in.nextLong() - x;
  y = in.nextLong() - y;
  long d = gcd(p,q);  
  boolean res = false;
  if (x%d==0 && y%d==0) {
	  x /= d; y /= d; p /= d; q /= d;
	  if (p%2+q%2==1) res = true; else
		  res = ((x+y)%2==0);
  }
  if (res) out.print("YES"); else out.print("NO");	  
  in.close(); out.close();  
}
}



