import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
Vector<Integer>[] a;
int n;
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  n = nextInt();
  a = new Vector[n];
  for (int i=0; i<n; i++) a[i] = new Vector<Integer>();
  for (int i=1; i<n; i++) {
	  int x = nextInt()-1;
	  a[x].add(i);
	  a[i].add(x);
  }
  
  int[] d,Q,p;
  d = new int[n]; 
  Arrays.fill(d, -1);
  Q = new int[n];
  int s = 0, t = 0; Q[0] = 0; d[0] = 0;
  while (s<=t) {
	  int v = Q[s++];
	  for (int x:a[v])
		  if (d[x]<0) {
			  d[x] = d[v]+1;
			  Q[++t] = x;
		  }
  }
  int max = 0;
  for (int i=0; i<n; i++)
	  if (d[i]>d[max]) max = i;
  Arrays.fill(d, -1);
  s = 0; t = 0; Q[0] = max; d[max] = 0;
  p = new int[n];
  while (s<=t) {
	  int v = Q[s++];
	  for (int x:a[v])
		  if (d[x]<0) {
			  d[x] = d[v]+1;
			  Q[++t] = x;
			  p[x] = v;
		  }
  }  
  int x = Q[n-1];
  int r = d[x];
  int r1 = 0, r2 = 0;
  while (d[x]>1+r/2) x = p[x];
  r1 = x; r2 = p[x];
  r1++; r2++;
  if (r%2==0) out.print(r2); else {
	  if (r1>r2) {int tt = r1; r1 = r2; r2 = tt;}
	  out.print(r1+" "+r2);
  }
	
  
  out.close(); 
 
}

}

