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




public void solve() throws IOException {
	int n = nextInt();
	int m = nextInt();
	boolean[][] a = new boolean[n][n];
	while (m-->0) {
		int x = nextInt()-1;
		int y = nextInt()-1;
		a[x][y] = a[y][x] = true;		
	}
	int res = n, str = -1, stl = -1;
	int[] r = new int[n];
	int[] d = new int[n];
	int[] q = new int[n];
	int[] p = new int[n];
	int[] best = new int[n];
	int h = 0, t = 0;
	for (int s=0; s<n; s++) {
		Arrays.fill(d, 0);
		p[s] = -1; d[s] = 1; 
		h = t = 0; q[t++] = s;		
		while (h<t) {
			int v = q[h++];
			for (int i=0; i<n; i++)
				if (d[i]==0 && a[v][i]) {
					q[t++] = i;
					d[i] = d[v]+1;
					p[i] = v;
				}
		}
		if (d[q[n-1]]<res) {
			res = d[q[n-1]];
			str = s;
			for (int i=0; i<n; i++) r[i] = p[i];
		}
		best[s] = d[q[n-1]];	
	}
	boolean fl = false;
	
	for (int x=0; x<n; x++)
		for (int y=x+1; y<n; y++)
		//	if (best[x]==best[y] && best[x]==res) {
		if (a[x][y]){					
				
				Arrays.fill(d, 0);
				p[x] = -1; d[x] = 1; 
				p[y] = -1; d[y] = 1; 
				h = t = 0; q[t++] = x; q[t++] = y;		
				while (h<t) {
					int v = q[h++];
					for (int i=0; i<n; i++)
						if (d[i]==0 && a[v][i]) {
							q[t++] = i;
							d[i] = d[v]+1;
							p[i] = v;
						}
				}
				if (d[q[n-1]]<res) {
					res = d[q[n-1]];
					fl = true;
					str = x;
					stl = y;
					for (int i=0; i<n; i++) r[i] = p[i];
				}
				
			}
	if (stl>=0) out.println((str+1)+" "+(stl+1));
	for (int i=0; i<n; i++)
		if (r[i]>=0) out.println((i+1)+" "+(r[i]+1));
	
}
}







