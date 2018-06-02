import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
Vector[] a;
int[] r;
boolean[] f;

public static void main(String[] args) throws IOException {
new Main().run();
}
int solv(int pl, int p) {
	f[p] = true;
	int res = 0;
	if (pl==2) res = 1;
	if (a[p].size()==0) {
		if (pl==1) {r[p]=0; return 0;}
		if (pl==2) {r[p]=1; return 1;}
	}
	for (Iterator it = a[p].iterator(); it.hasNext();) {
		int x = (Integer) it.next();
		if (f[x]) continue;
		x = solv(3-pl,x);
		if (pl==1) {
			if (x>res) res = x;
		} else {
			if (x<res) res = x;
		}
	}
	r[p] = res;
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int k = in.nextInt();
  a = new Vector[n+1];
  r = new int[n+1];
  f = new boolean[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector();
  for (int i=1; i<n; i++) {
	  int x = in.nextInt();
	  int y = in.nextInt();
	  a[x].add(y);
	  a[y].add(x);
  }
  solv(1,k);
  int res = n+1;
  for (Iterator it = a[k].iterator(); it.hasNext();) {
	  Integer x = (Integer) it.next();
	  if (r[x]==1) res = Math.min(res, x);
  } 
  if (res>n) 
	  out.print("First player loses");	  
  else 
	  out.print("First player wins flying to airport "+res);
  in.close(); out.close();
}

}