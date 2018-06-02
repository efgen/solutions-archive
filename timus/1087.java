import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
int n,m;
int[] h,a;

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  n = in.nextInt(); 
  m = in.nextInt();
  h = new int[m+1];
  a = new int[n+1];
  for (int i=1; i<=m; i++) h[i] = in.nextInt();
  a[0] = 1;
  for (int p=1; p<=n; p++) {
	  a[p] = -1;
	  for (int i=1; i<=m; i++) {
		  int x = p - h[i];
		  if (x<0) continue;
		  if (a[x]<0) { a[p] = 1; break; }
	  }
  }  
  if (a[n]>0) out.print(1); else out.print(2);
  in.close();  out.close();
}

}


