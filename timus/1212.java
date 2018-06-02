import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
static BufferedReader br;
static Scanner in;
static StreamTokenizer inST;
static PrintWriter out;

public static void main(String[] args) throws IOException {
	br = new BufferedReader(new InputStreamReader(System.in));
	in = new Scanner(br);
	inST = new StreamTokenizer(br);
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	new Thread(new Main()).start();
}
static int nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return (int)inST.nval;
}
int n,m,k;
class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+" "+y;
	}
}
class Ship {
	int x, y, len;
	Ship(int y, int x,int len) {
		this.x = x;
		this.y = y;
		this.len = len;		
	}
}
Vector<Ship> V = new Vector<Ship>(), H = new Vector<Ship>(); 
Set<Point> Relax(Set<Point> t,int l, int r) {
	Set<Point> newt = new HashSet<Point>();
	for (Point p:t) {
		if (l>p.y ||r<p.x ) {
			newt.add(p);
			continue;		
		}
		if (l<=p.x) { 
			if (r+1<=p.y) newt.add(new Point(r+1,p.y));
			continue;
		}
		if (r>=p.y) { 	
			if (p.x<=l-1) newt.add(new Point(p.x,l-1));
			continue;
		}
		if (p.x<=l-1) newt.add(new Point(p.x,l-1));
		if (r+1<=p.y) newt.add(new Point(r+1,p.y));				
	}
	return newt;	
}
int calc(Set<Point> t) {
	int res = 0;
	for (Point p:t) {	
		int x = p.y-p.x+2-k;
		if (x>0) res += x;
	}
	return res;
}
public void run() {
	n = in.nextInt();
	m = in.nextInt();
	k = in.nextInt();
	while (k-->0) {
		Ship s = new Ship(in.nextInt(),in.nextInt(),in.nextInt());
		char c = in.next().trim().charAt(0);
		if (s.len==1) {
			V.add(s);
			H.add(s);
		} else
		if (c=='V') V.add(s); else H.add(s);		
	}
	k = in.nextInt();
	long res = 0;
	for (int i=1; i<=n; i++) {
		Set<Point> t = new HashSet<Point>(); t.add(new Point(1,m));
		for (Ship s:H) {
			if (Math.abs(s.x-i)>1) continue;	
			int l = s.y-1; if (l<1) l = 1;
			int r = s.y+s.len; if (r>m) r = m;
			t = Relax(t,l,r);			
		}
		for (Ship s:V) {
			if (i>=s.x-1 && i<=s.x+s.len) {
				int l = s.y-1; if (l<1) l = 1;
				int r = s.y+1; if (r>m) r = m;
				t = Relax(t,l,r);
			}
		}
		res += calc(t);
	}
	if (k>1) {
	for (int j=1; j<=m; j++) {
		Set<Point> t = new HashSet<Point>(); t.add(new Point(1,n));
		for (Ship s:V) {
			if (Math.abs(s.y-j)>1) continue;	
			int l = s.x-1; if (l<1) l = 1;
			int r = s.x+s.len; if (r>n) r = n;
			t = Relax(t,l,r);			
		}
		for (Ship s:H) {
			if (j>=s.y-1 && j<=s.y+s.len) {
				int l = s.x-1; if (l<1) l = 1;
				int r = s.x+1; if (r>n) r = n;
				t = Relax(t,l,r);
			}
		}
		res += calc(t);		
	}
	}
	out.print(res);
	out.flush();
}
}


