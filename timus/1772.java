import java.io.*;         
import java.util.*;         
import java.math.*;         
 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final long inf = 1l<<60;
 
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
//	new Main().run();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}
class STree {
	int n, p;
	int[] a;
	boolean[] f;
	public STree(int sz) {
		n = sz;
		sz *= 5;
		a = new int[sz];
		f = new boolean[sz];
	}
	void fill(int q, int L, int R, int l, int r, int val) {
		if (l==L && r==R) {
			a[q] = val;
			f[q] = true;
			return;
		}
		if (f[q]) {
			f[2*q] = f[2*q+1] = true;			
			a[2*q] = a[2*q+1] = a[q];
			f[q] = false;			
		}
		int mid = (L+R)>>1;		
		if (l<=mid) fill(2*q, L, mid, l, Math.min(mid, r), val);
		if (mid<r) fill(2*q+1, mid+1, R, Math.max(l, mid+1), r, val);
	}
	
	int get(int q, int L, int R, int pos) {
		if (L==R) {
			return a[q];
		}
		if (f[q]) return a[q];
		int mid = (L+R)>>1;
		if (pos<=mid) return get(2*q, L, mid, pos); else return get(2*q+1, mid+1, R, pos);
	}
}
public void solve() throws IOException {
	int n = nextInt();	
	int start = nextInt();
	int m = nextInt();
	int[] l = new int[m+1];
	int[] r = new int[m+1];
	long[] dl = new long[m+1];
	long[] dr = new long[m+1];
	for (int i=1; i<=m; i++) {
		l[i] = nextInt();
		r[i] = nextInt();
	}
	STree t = new STree(n);
	Arrays.fill(dl, inf);
	Arrays.fill(dr, inf);
	for (int i=m; i>0; --i) {
		if (l[i]>1) {
			int x = l[i]-1;
			int v = t.get(1, 1, n, x);
			if (v==0) dl[i] = 0; else {
				dl[i] = Math.min(x-l[v]+dl[v], r[v]-x+dr[v])+1;
			}
		}
		if (r[i]<n) {
			int x = r[i]+1;
			int v = t.get(1, 1, n, x);
			if (v==0) dr[i] = 0; else {
				dr[i] = Math.min(x-l[v]+dl[v], r[v]-x+dr[v])+1;
			}
		}
		t.fill(1, 1, n, l[i], r[i], i);
	}
	int v = t.get(1, 1, n, start);
	long res = 0;
	if (v>0) res =  Math.min(start-l[v]+dl[v], r[v]-start+dr[v])+1;
	out.println(res);
	
	
}
  
}
 
 
  