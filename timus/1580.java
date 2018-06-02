import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
//int inf = 1000000000;   
double eps = 1e-10;

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
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
    	out = new PrintWriter(System.out);
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point {
	int x, y;
	Point(int xx, int yy) {
		x = xx; y= yy;
	}
}
double[] res;
int[] f, pr, val;
int n;
Vector<Point>[] a;
int[] d;
int cl;
boolean ck = false;
void dfs(int v) {
	f[v] = cl; 
	for (Point p:a[v]) 
		if (f[p.x]==0) {
			d[p.x] = d[v]+1;
			pr[p.x] = v;
			val[v] = p.y;
			dfs(p.x);
		} else
			if (!ck && (d[v]-d[p.x])%2==0) {
				ck = true;
				double ans = 0;
				int z = 1;
				int t = pr[v];
				while (t!=p.x) {
					ans += z*val[t];
					z *= -1;
					t = pr[t];
				}
				ans += z*val[t];
				ans += p.y;
				ans /= 2;
				res[v] = ans;
				dfs2(v);
			}
	
}
boolean OK = true;
boolean[] mark;
void dfs2(int v) {
	mark[v] = true;
	for (Point p:a[v])
		if (!mark[p.x]) {
			res[p.x] = p.y-res[v];
			dfs2(p.x);
		} else
			if (res[p.x]+res[v] != p.y) OK = false;
}
public void solve() throws IOException {
	n = nextInt();
	a = new Vector[n+1];
	for (int i=1; i<=n; i++) a[i] = new Vector<Point>();
	int m = nextInt();
	while (m-->0) {
		int x = nextInt();
		int y = nextInt();
		int w = nextInt();
		a[x].add(new Point(y, w));
		a[y].add(new Point(x, w));
	}
	f = new int[n+1];
	d = new int[n+1];
	pr = new int[n+1];
	val = new int[n+1];
	res = new double[n+1];
	mark = new boolean[n+1];
	for (int i=1; i<=n; i++)
		if (f[i]==0) {
			++cl;
			ck = false;
			dfs(i);
			if (!ck) {
				out.println("IMPOSSIBLE");
				return;
			}
		}
	if (OK) for (int i=1; i<=n; i++) out.printf(Locale.US, "%1.2f\n", res[i]); else out.println("IMPOSSIBLE");
}
}







