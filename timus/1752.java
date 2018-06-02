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

int n;
Vector<Integer>[] a;

int bfs(int v) {
	Queue<Integer> Q = new LinkedList<Integer>();
	Q.add(v);
	int[] d = new int[n+1];
	d[v] = 1;
	int res = v;
	while (!Q.isEmpty()) {
		v = Q.poll();
		for (int x:a[v])
			if (d[x]==0) {
				d[x] = d[v]+1;
				Q.add(x);
				res = x;
			}
	}
	return res;
}
int[] d1, d2;
int[][] dp1, dp2;
void dfs1(int v) {
	for (int x:a[v]) if (d1[x]==0){
		d1[x] = d1[v]+1;
		dp1[0][x] = v;
		for (int k=0; k<14; k++)
			if (dp1[k][x]>0) dp1[k+1][x] = dp1[k][dp1[k][x]];
		dfs1(x);
	}
}
void dfs2(int v) {
	for (int x:a[v]) if (d2[x]==0){
		d2[x] = d2[v]+1;
		dp2[0][x] = v;
		for (int k=0; k<14; k++)
			if (dp2[k][dp2[k][x]]>0) dp2[k+1][x] = dp2[k][dp2[k][x]]; else break;
		dfs2(x);
	}
}
public void solve() throws IOException {
	n = nextInt();
	int m = nextInt();
	a = new Vector[n+1];
	for (int i=1; i<=n; i++) a[i] = new Vector<Integer>();
	for (int i=1; i<n; i++) {
		int x = nextInt();
		int y = nextInt();
		a[x].add(y);
		a[y].add(x);
	}
	int root1 = bfs(1);
	int root2 = bfs(root1);
	dp1 = new int[15][n+1];
	dp2 = new int[15][n+1];
	d1 = new int[n+1];
	d2 = new int[n+1];
	d1[root1] = 1; dfs1(root1);
	d2[root2] = 1; dfs2(root2);
	//out.println(root1+" "+root2);
	while (m-->0) {
		int x = nextInt();
		int dist = nextInt();
		//out.print(x+" "+dist+":");
		if (dist<=d1[x]-1) {
			for (int k=14; k>=0; --k)
				if (dist>=(1<<k)) {
					x = dp1[k][x];
					dist -= 1<<k;					
					if (dist==0) break;
				}
			out.println(x);
		} else
			if (dist<=d2[x]-1) {
				for (int k=14; k>=0; --k)
					if (dist>=(1<<k)) {
						x = dp2[k][x];
						dist -= 1<<k;
						if (dist==0) break;						
					}
				out.println(x);
			} else out.println(0);
	}
}
}







 



