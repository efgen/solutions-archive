import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   

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
      //  br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        //out= new PrintWriter(new File("output.txt"));
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
int[] p, rank;
void init(int n) {
	p = new int[n+1];
	rank = new int[n+1];
	for (int i=1; i<=n; i++) p[i] = i;
}
int find(int x) {
	if (x!=p[x]) p[x] = find(p[x]);
	return p[x];
}
void link(int x, int y) {
	if (rank[x]<rank[y]) {
		p[x] = y;
	} else {
		p[y] = x;
		if (rank[x] == rank[y]) rank[y]++;
	}
}
public void solve() throws IOException {
	int n = nextInt();
	int m = nextInt();
	init(n);
	int[] x = new int[m];
	int[] y = new int[m];
	for (int i=0; i<m; i++) {
		x[i] = nextInt();
		y[i] = nextInt();
	}
	int q = nextInt();
	int[] z = new int[q];
	HashSet<Integer> hs = new HashSet<Integer>();
	for (int i=0; i<q; i++) {
		z[i] = nextInt()-1;
		hs.add(z[i]);
	}
	int k = n;
	for (int i=0; i<m; i++) if (!hs.contains(i)) {
		int a = find(x[i]);
		int b = find(y[i]);
		if (a!=b) {
			k--;
			link(a,b);
		}
	}
	int[] r = new int[q];
	for (int i=q-1; i>=0; i--) {
		int a = find(x[z[i]]);
		int b = find(y[z[i]]);
		r[i] = k;
		if (a!=b) {			
			k--;
			link(a,b);
		}
	}
	for (int i=0; i<q; i++) out.print(r[i]+" ");
}
} 












