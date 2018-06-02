import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.awt.geom.*;         
import java.util.regex.*;
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
int inf = 1000000000;
class Point implements Comparable<Point> {
	int x, y, z;
	Point (int xx, int yy, int zz) {
		x = xx; y = yy; z = zz;
	}
	public int compareTo(Point o) {
		return x - o.x;
	} 	
}
int gcd(int a, int b) {
	if (a==0) return b; else return gcd(b, a%b);
}
int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}

long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}

public void run()  {      
    try {          
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}

int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
int[] cp = {10, 5, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
long[] g;

long n, best = 1;
long bv = 1;

void gen(long x, int k, long d) {
	//if (x>n || x<0) return;
	if (k>=p.length) return;
	if (d>bv || (d==bv && x<best)) {
		bv = d;
		best = x;
	}
	for (int i=1; i<=cp[k] && x<=g[k]; i++) {
		x *= p[k];
		gen(x, k+1, d*(i+1));
	}
}

public void solve() throws IOException {
	int tt = Integer.parseInt(br.readLine());
	while (tt-->0) {
		best = 1; bv = 1;
		n = Long.parseLong(br.readLine());
		g = new long[p.length];
		for (int i=0; i<p.length; i++) g[i] = n/p[i];
		gen(1, 0, 1);
		out.println(best+" "+bv);
		if (1==1)continue;
		long p = 2;
		while (best>1) {
			while (best%p==0) {
				out.print(p+" ");
				best /= p;
			}
			p++;
		}
	}
		
}
}







 



