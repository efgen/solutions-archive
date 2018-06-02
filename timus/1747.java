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
	int id;
	double x, y;
	Point next;
	double val, res;
	Point (double xx, double tt, int ii) {
		x = xx%tt; y = tt; id = ii;
	}
	public int compareTo(Point o) {
		return Double.valueOf(x).compareTo(o.x);
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
	int n = nextInt()-1;
	long p = nextInt();
	long[] f = new long[n+2];
	f[n+1] = 1%p;
	for (int i=n; i>0; --i) f[i] = f[i+1]*i%p; f[0] = f[1];
	long res = 0;
	long x = 1;
	if (n%2==1) x = -x;
	for (int t=0; t<=n; t++) {
	//	out.println(t+" "+" "+x+" "+(x*f[t]));
		res += x*f[t+1]%p;	
		x = ((n-t)*(n+t+1l)>>1)*x%p;
		x = -x;		
		
	}
	res %= p;
	if (res<0) res += p;
	out.println(res);
}
}






 


