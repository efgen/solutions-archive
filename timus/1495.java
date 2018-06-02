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
  int n = in.nextInt();
  if (n<3) {
	  out.print(n);
	  out.close();
	  return;
  }
  int[] p = new int[n];
  boolean[] a = new boolean[n];
  int[] c = new int[n];
  int[] q = new int[n];
  int s = 0, t = 1; 
  q[0] = 1; q[1] = 2;
  a[1] = true; a[2] = true;
  c[1] = 1; c[2] = 2;
  p[1] = -1; p[2] = -1;
  while(s<=t) {
	  int x = q[s++];
	  if (x==0) break;
	  int x1 = (10*x+1)%n;
	  int x2 = (10*x+2)%n;
	  if (!a[x1]) {
		  a[x1] = true;
		  c[x1] = 1;
		  p[x1] = x;
		  q[++t] = x1;
	  }
	  if (!a[x2]) {
		  a[x2] = true;
		  c[x2] = 2;
		  p[x2] = x;
		  q[++t] = x2;
	  }
  }
  if (!a[0]) out.print("Impossible"); else {
	  int r = 0;
	  int x = 0;
	  String res = "";
	  while (x>=0 && r<=30) {
		  res = c[x]+""+res;
		  x = p[x];		 
		  r++;		 
	  }
	  if (r<=30) out.print(res); else out.print("Impossible");
  } 
  in.close(); out.close();
}

}

