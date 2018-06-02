import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
int inf = 1000000000;   

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
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point implements Comparable<Point>{
	int x;
	double v;
	Point(int xx, double vv) {
		x = xx; v = vv;
	}
	public int compareTo(Point p) {
		if (p.v==v) return x-p.x; else return Double.valueOf(v).compareTo(p.v);
	}
}
int[] dx = {1,1,1,0,0,-1,-1,-1};
int[] dy = {1,0,-1,1,-1,-1,0,1};
int[] head, next, e;
double[] ves;
int kk;
void add(int x, int y, double w) {
	kk++;
	next[kk] = head[x];
	e[kk] = y;
	ves[kk] = w;
	head[x] = kk;	
}
public void solve() throws IOException {
	String[] ss = br.readLine().split(" ");
	int w = Integer.parseInt(ss[0]);
	int h = Integer.parseInt(ss[1]);
	int K = Integer.parseInt(ss[2]);
	double VV = Double.parseDouble(ss[3]);
	int n = w*h;
	boolean[][] map = new boolean[h+2][w+2];
	for (int i=1; i<=h; i++) {
		char[] s = br.readLine().toCharArray();
		for (int j=0; j<w; j++) map[i][j+1] = s[j]=='.';
	}
	int m = 8*n+16;
	head = new int[n];
	e = new int[m];
	next = new int[m];
	ves = new double [m];
	for (int i=1; i<=h; i++)
		for (int j=1; j<=w; j++)
			if (map[i][j])
				for (int k=0; k<8; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if (map[x][y]) add((i-1)*w+j-1, (x-1)*w+y-1, Math.sqrt(dx[k]*dx[k]+dy[k]*dy[k]));
				}
	K++;
	int[] pos = new int[K];
	for (int i=0; i<K; i++) {
		int xx = nextInt();
		int yy = nextInt();
		pos[i] = (yy-1)*w+xx-1;
	}
	double[] d = new double[n];
	int[] f = new int[n];
	boolean[] dost = new boolean[n];
	double res = 0;
	int oldpl = pos[0];
	int[] Q = new int[n];
	int qh = 0, qt = 0;
	for (int s=0; s<K-1; s++) {		
		int req = pos[s+1];
		if (s>0 && !dost[req]) continue;		
		Arrays.fill(f, 0);
		Arrays.fill(d, inf);
		int p = oldpl;
		d[p] = 0;
		qh = qt = 0;
		Q[qt++] = p;
		f[p] = 1;
		while (qh!=qt) {			
			p = Q[qh++];
			if (qh==n) qh = 0;
			f[p] = 2;			
			for (int t = head[p]; t>0; t = next[t]) 
				if (d[e[t]] > d[p]+ves[t]) {
					d[e[t]] = d[p]+ves[t];
					if (f[e[t]]==0) {						
						Q[qt++] = e[t];
						if(qt==n) qt = 0;
						f[e[t]] = 1;
					} else 
					if (f[e[t]]==2) {
						--qh;
						if (qh<0) qh = n-1;
						Q[qh] = e[t];
						f[e[t]] = 1;
					}
					
				}				
		}
		if (s==0) {
			for (int i=0; i<n; i++) dost[i] = f[i]==2;
		}
		if (f[req]==2) { 
			res += d[req];
			oldpl = req;
		}  		
	}
	out.printf(Locale.US,"%1.2f",res/VV);
}
}







