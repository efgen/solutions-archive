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
	int x, t, id;
	Point (int xx, int tt, int ii) {
		x = xx; t = tt; id = ii;
	}
	public int compareTo(Point o) {
		if (x==o.x) return t-o.t;
		return x - o.x;
	} 	
}
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b, a%b);
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



public void solve() throws IOException {
	int n = nextInt();
	if (n==1) {
		out.print(nextInt()-1);
		return;
	}
	int s = nextInt();
	int max = 0;
	BigInteger res = BigInteger.valueOf(s-1).multiply(BigInteger.valueOf(n));
	//out.println(res);
	int[] a = new int[n];
	for (int i=0; i<n; i++) {
		a[i] = nextInt()-1;
		a[i] = Math.min(a[i], s-1-a[i]);
		if (a[i]>max) max = a[i];
	}
	max = s-max-1;
	Arrays.sort(a);
	int p = 0;
	for (int len=1; len<=max; len++) {
		while (p<n && a[p]<len) p++;
		res = res.add(BigInteger.ONE.shiftLeft(n-p));
	}
	
	out.print(res);
}
	
	

}







 



