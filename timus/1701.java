import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
//Scanner in;   
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
        //in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

int[] p, d, min;
int find(int x) {
	if (x==p[x]) return x;
	int pr = p[x];	
	p[x] = find(pr);
	d[x] += d[pr];
	if (d[x]<min[p[x]]) min[p[x]] = d[x];
	return p[x];
}
public void solve() throws IOException {
	int n = nextInt();
	int m = nextInt();
	p = new int[n];
	d = new int[n];
	min = new int[n];
	for (int i=0; i<n; i++) p[i] = i;
	for (int k=1; k<=m; k++) {
		int x = nextInt();
		int y = nextInt();
		int rz = nextInt();
		int rx  = find(x);
		int ry = find(y);
		if (rx==ry) {
			if (d[x]-d[y]!=rz) {
				out.println("Impossible after "+k+" statements");
				return;
			}
		} else {
			if (ry==0) {
				int t = rx; rx = ry; ry = t; rz = -rz;
				t = x; x =y; y = t;
			}
			p[ry] = rx;
			d[ry] = d[x]-d[y]-rz;
			if (d[ry]+min[ry] < min[rx]) min[rx] = d[ry]+min[ry];
			if (min[0]<0 )   {
				out.println("Impossible after "+k+" statements");
				return;
			}
		}
	}
	out.println("Possible");
	for (int i=0; i<n; i++) {		
		int r = min[find(i)];
		out.println(d[i]-r);
	}
}
}







