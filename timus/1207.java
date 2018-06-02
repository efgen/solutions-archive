import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

class Point implements Comparable {
	int x,y,k;
	Point(int x,int y, int k) {
		this.x = x; this.y = y; this.k = k;
	}
	public int compareTo(Object o) {
		Point p = (Point)o;
		long z = (long)p.x*this.y-(long)p.y*this.x;
		if (z<0) return -1; else return 1;
	}
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out); 
  int n = nextInt();
  Point[] a = new Point[n];
  for (int i=0; i<n; i++) a[i] = new Point(nextInt(),nextInt(),i);
  int min = 0;
  for (int i=0; i<n; i++)
	  if ((a[min].y>a[i].y) || (a[min].y==a[i].y && a[min].x>a[i].x)) min = i;
  Point q = a[min]; a[min] = a[0]; a[0] = q;
  for (int i=n-1; i>0; i--) {
	  a[i].x -= a[0].x;
	  a[i].y -= a[0].y;
  }
  Arrays.sort(a,1,n);
  out.print((1+a[0].k)+" "+(1+a[n/2].k));
  out.close();
}

}


