import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

class Point implements Comparable<Point>{
	int x, y, r;
	Point(int rr, int xx, int yy) {
		x = xx; y = yy; r = rr;
	}
	public int compareTo(Point o) {
		return x-o.x;
	}
}
class Rec {
	int minx, miny, maxx, maxy;
	long S() {
		return Math.max(maxx-minx, 100l)*Math.max(maxy-miny, 100l);
	}
}
Rec f(Point[] a, int b, int e) {
	Rec res = new Rec();
	res.minx = a[b].x-a[b].r;
	res.maxx = a[b].x+a[b].r;
	res.miny = a[b].y-a[b].r;
	res.maxy = a[b].y+a[b].r;
	for (int i=b+1; i<=e; i++) {
		if (a[i].x-a[i].r<res.minx) res.minx = a[i].x-a[i].r;
		if (a[i].x+a[i].r>res.maxx) res.maxx = a[i].x+a[i].r;
		if (a[i].y-a[i].r<res.miny) res.miny = a[i].y-a[i].r;
		if (a[i].y+a[i].r>res.maxy) res.maxy = a[i].y+a[i].r;
	}
	return res;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int n = nextInt();
  Point[] a = new Point[n];
  for (int i=0; i<n; i++) a[i] = new Point(nextInt(), nextInt(), nextInt());
  Arrays.sort(a);
  long res = f(a,0,n-1).S();
  for (int k=1; k<n; k++) {
	  Rec r1 = f(a, 0, k-1);
	  Rec r2 = f(a, k, n-1);
	  if (r1.maxx<=r2.minx) res = Math.min(res, r1.S()+r2.S());
  }
  for (int i=0; i<n; i++) {
	  int q = a[i].x; a[i].x = a[i].y; a[i].y = q;
  }
  Arrays.sort(a);
  for (int k=1; k<n; k++) {
	  Rec r1 = f(a, 0, k-1);
	  Rec r2 = f(a, k, n-1);
	  if (r1.maxx<=r2.minx) res = Math.min(res, r1.S()+r2.S());
  }
  out.println(res);
  out.close();    
}   

}



