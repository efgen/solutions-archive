import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}
class Node {
	int l,r,k;
	Node L,R;
	Node(int l, int r) {
		int k = (r-l+1);
		this.l = l; this.r = r; this.k = k/2+k%2;
		if (k>1) {
			this.L = new Node(l,(r+l)/2);
			this.R = new Node((r+l)/2+1,r);
		} else {
			this.L = null;
			this.R = null;
		}
	}
	int del(int x) {
		if (x<=this.k) { 
			this.k--;
			if (this.l==this.r) 
				return this.l; 
			else
				return this.L.del(x); 
		}
		else return this.R.del(x-this.k);		
	}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  int m = in.nextInt()-2;
  Node root = new Node(1,n);
  int x = 1;
  while (n>0) {
	  x = (x+m)%n+1;
	  out.print(root.del(x));
	  out.print(" ");
	  n--;
  } 
  in.close(); out.close();
}
}
