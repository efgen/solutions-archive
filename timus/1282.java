import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
Vector[] a;
int n;
int[] p;
int hz = 666;

public static void main(String[] args) throws IOException {
new Main().run();
}
int solv(int pos, int player) {
	if (p[pos]!=hz) return p[pos]; 
	int res = 0;
	for (Iterator it = a[pos].iterator(); it.hasNext();) {
		Integer v = (Integer) it.next();		
		solv(v,3-player);
	}
	if (player==1) {
		res = -1;
		for (Iterator it = a[pos].iterator(); it.hasNext();) {
			Integer v = (Integer) it.next();
			if (p[v]>res) res = p[v];		
		}
	} else {
		res = 1;
		for (Iterator it = a[pos].iterator(); it.hasNext();) {
			Integer v = (Integer) it.next();
			if (p[v]<res) res = p[v];		
		}		
	}
	p[pos] = res;
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  n = in.nextInt();
  a = new Vector[n+1];
  p = new int[n+1];
  Arrays.fill(p, hz);
  for (int i=1; i<=n; i++) a[i] = new Vector();
  for (int i=2; i<=n; i++) {
	  in.nextLine();
	  String s = in.next();
	  a[in.nextInt()].add(i);
	  if (s.charAt(0)=='L')
		  p[i] = (int)in.nextDouble();	  
  } 
  int res = solv(1,1);
  if (res>0) out.print("+1"); else out.print(res);
  
  
  in.close(); out.close();
}

}