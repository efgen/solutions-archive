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
  int[] a = new int[n+1];
  int[] b = new int[n+1];
  int[] d = new int[n+1];
  int[] p = new int[n+1];
  int q = 0;
  for (int i=1; i<=n; i++) {
	  a[i] = in.nextInt();
	  b[i] = in.nextInt();
	  if (a[i]>b[i]) { q = a[i]; a[i] = b[i]; b[i] = q;}
	  d[i] = 1;
	  p[i] = i;
  }
  for (int i=1; i<=n; i++) {
	  int min = i;
	  for (int j=i+1; j<=n; j++)
		  if (a[j]<a[min]) min = j;
	  q = a[i]; a[i] = a[min]; a[min] = q;
	  q = b[i]; b[i] = b[min]; b[min] = q;	 
  }
  for (int i=n; i>0; i--) {
	  for (int j=i+1; j<=n; j++)
		  if (b[i]<=a[j])
			  if (d[i]<d[j]+1) {
				  d[i] = d[j]+1;
				  p[i] = j;
			  }
  }
  int x = 1;
  for (int i=1; i<=n; i++)
	  if (d[i]>d[x]) x = i;
  out.println(d[x]);
  while (true) {
	  out.println(a[x]+" "+b[x]);
	  if (x==p[x]) break; else x = p[x]; 
  }  
  in.close(); out.close();
}

}