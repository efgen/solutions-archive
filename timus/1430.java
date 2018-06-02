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
  int a = in.nextInt();
  int b = in.nextInt();
  int n = in.nextInt();
  boolean f = true;
  if (a>b) { int q = a; a = b; b = q; f = false; }
  int res = n%a, bx = n/a, by = 0;
  int t = 0;
  TreeSet ost = new TreeSet(); ost.add(res);
  while (res>0) {
	  t++; n -= b;
	  if (n<0) break;
	  int d = n%a;
	  if (ost.contains(d)) break; else ost.add(d);
	  if (d<res) {
		  res = d;
		  by = t;
		  bx = n/a;
	  }
  }
  if (f) out.println(bx+" "+by); else out.println(by+" "+bx);  
  in.close(); out.close();
}

}
