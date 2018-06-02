import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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
int[] a = new int[20];
int[] best = new int[20];
int[][] rr = new int[20][];
void gen(TreeSet<Integer> t, int k) {
	if (k==10) return;
	if (a[k-1]<best[k-1]) {
		best[k-1] = a[k-1];
		rr[k-1] = a.clone();
		//for (int i=1; i<k; i++) out.print(a[i]+" "); out.println();		
	}
	for (int x=a[k-1]+1; x<=45; x++) if (!t.contains(x)){
		boolean ok = true;
		for (int y:t) if (t.contains(x+y)) {
			ok = false; break;
		}
		if (ok) {
			TreeSet<Integer> tt = new TreeSet<Integer>(t);
			for (int y:t) tt.add(x+y);
			tt.add(x);
			a[k] = x;
			gen(tt, k+1);
		}
	}
}
public void solve() throws IOException {
	Arrays.fill(best, 100000000);
	//gen(new TreeSet<Integer>(), 1);
	for (int len=1; len<10; len++) {
		if (rr[len]==null) continue;
		for (int i=1; i<=len; i++) out.print(rr[len][i]+" "); out.println();
	}
	int n = 100;
	long[] d = new long[n+1]; d[1] = 1;
	for (int i=1; i<n; i++)  {
		d[i+1] = 2*d[i]-d[i-(int)Math.floor(0.5+Math.sqrt(2*i))];
		//out.print(d[i]+" ");
	}
	int t = nextInt()-1;
	if (d[t+1]-d[0]<=nextInt()) {
		out.println("YES");
		for (int i=0; i<=t; i++) out.print((d[t+1]-d[t-i])+" ");
	} else out.println("NO");
}
}






