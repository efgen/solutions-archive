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
	int a, n, id;
	Point (int xx, int tt, int ii) {
		a = xx%tt; n = tt; id = ii;
	}
	public int compareTo(Point o) {
		return n - o.n;
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

int pow(int x, int n, int mod) {
	int a = 1, b = x;
	while (true) {
		if ((n&1)==1) a = (a*b)%mod;		
		n >>= 1;
		if (n>0) b = b*b%mod; else break;
	}
	return a;
}


public void solve() throws IOException {
	Vector<Integer> P = new Vector<Integer>();
	Vector<Integer> fi = new Vector<Integer>(); fi.add(1);
	Vector<Integer> tmp = new Vector<Integer>();
	int n = 1<<15;
	boolean[] f = new boolean[n];
	for (int i=2; i<n; i++)
		if (!f[i]) {
			for (int j=i*i; j<n; j+=i) 
				f[j] = true;
			P.add(i);
		}
	for (int p:P) {
		int pp = p-1;
		int pn = pp;
		tmp.clear();
		int d = 2;
		while (pn>1) {
			if (pn%d==0) {
				while (pn%d==0) pn /= d;
				tmp.add(d);
			}
			if (d*d>=n) d = pn; else d++;
		}
		for (int x=2; x<p; x++) {
			boolean ok = true;
			for (int dd:tmp)
					if (pow(x, pp/dd, p)==1) {
						ok = false;
						break;
					}
				
			if (ok) {
				fi.add(x);
				break;
			}
			
		}
	} 
	
	
	int tt = nextInt(), pos = 0;
	int[] ans = new int[tt];
	int[] ans2 = new int[tt];
	Point[] a = new Point[tt];
	for (int i=0; i<tt; i++) {
		a[i] = new Point(nextInt(), nextInt(), i);
	}
	Arrays.sort(a);
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(1<<8);
	int prev = -1, g = -1, msq = -1, msq2 = -1 ,mod = -1;
	
	for (Point test:a) {
		if (test.n!=prev) {
			mod = test.n;
			while (P.elementAt(pos)<mod) pos++;
			g = fi.elementAt(pos);
			map.clear();
			
			msq = (int)Math.sqrt(mod)+1;
			msq2 = mod/msq+(mod%msq==0?0:1);
			int t = pow(g, msq, mod);
			int tp = t;
			for (int i=1; i<=msq2; i++) {
				map.put(tp, i*msq);
				tp = tp*t%mod;
			}
			prev = mod;
		}
		int r = 0;
		int cur = test.a;
		for (int i=0; i<=msq; i++) { 
			Integer X = map.get(cur);
			if (X!=null)  {
				int pow = X-i;
				if ((pow&1)==0) {
					r = pow(g, pow>>1, mod);				
				}
				break;
		} else cur = cur*g%mod;
		}
		ans[test.id] = Math.min(r, mod-r);
		ans2[test.id] = mod - ans[test.id];
	//	
	}
	for (int i=0; i<tt; i++) if (ans[i]==0) out.println("No root"); else 
	if (ans[i]==ans2[i]) out.println(ans[i]); else {
		out.print(ans[i]);
		out.print(" ");
		out.println(ans2[i]);
	}
}
	
	

}







 



