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


int n;
Vector<Integer> path = new Vector<Integer>();
int[] zap;
int[][] a;
boolean[] f;
void dfs(int v) {
	f[v] = true;
	for (int i=1; i<=n; i++)
		if (a[v][i]>0) {
			a[v][i] = -a[v][i]; 
			a[i][v] = -a[i][v];
			dfs(i);
		}
	if (zap[v]>0) {
		int q = zap[v];
		zap[q] = 0;
		zap[v] = 0;
		dfs(q);
	}
	path.add(v);
}
public void solve() throws IOException {
	n = nextInt();
	a = new int[n+1][n+1];
	zap = new int[n+1];
	int pr = -1;
	for (int i=1; i<=n; i++) {
		int m = nextInt();
		if (m%2==1) {
			if (pr<0) pr = i; else {
				zap[i] = pr; zap[pr] = i;
				//out.println(pr+" "+i);
				pr = -1;
				
			}
		}
		while (m-->0) {
			int x = nextInt();
			a[i][x] = a[x][i] = 1;
		}
	}
	f = new boolean[n+1];
	for (int i=1; i<=n; i++) if (!f[i]) dfs(i);
	//for (int x:path) out.print(x+" "); out.println();
	int k = 1;
	for (int i=0; i<path.size()-1; i++) {
		int x = path.elementAt(i);
		int y = path.elementAt(i+1);
		if (a[x][y]!=0) {
			a[x][y] = k;
			a[y][x] = 3-k;
		}
		
	}
	/*for (int i=1; i<=n; i++) {
		for (int j=1; j<=n; j++) out.print(a[i][j]+" ");
		out.println();
	}*/
	for (int i=1; i<=n; i++) {
		for (int j=1; j<=n; j++)
			if (a[i][j]==1) out.print("Y "); else
				if (a[i][j]==2) out.print("G ");
		out.println();
	}
}
}






 



