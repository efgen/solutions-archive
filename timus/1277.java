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


int[] f;
boolean[] mark;
int n,s,t;
int ALL = 0;
int add;
boolean dfs(int v) {
	if (v==t) {
		ALL-=add;
		return true;	
	}
	mark[v] = true;
	for (int i=0; i<n; i++)
		if (!mark[i] && f[v*n+i]>=add && dfs(i)) {
			f[v*n+i]-=add;
			f[i*n+v]+=add;
			return true;
		}
	return false;
}
void maxflow() {
	mark = new boolean[n];
	for (add = 1<<13; add>0; add>>=1) {
		do {
			if (ALL<0) return;
			Arrays.fill(mark, false);
		} while(dfs(s));
	}
}
public void solve() throws IOException {
	ALL = nextInt();
	n = nextInt();
	int m = nextInt();
	s = nextInt()-1;
	t = nextInt()-1;
	int nn = 2*n;
	f = new int[nn*nn];
	
	for (int i=0; i<n; i++) f[i*nn+i+n] = nextInt();
	while (m-->0) {
		int x = nextInt()-1;
		int y = nextInt()-1;
		f[(x+n)*nn+y] = inf;
		f[(y+n)*nn+x] = inf;
	}
	
	f[s*nn+s+n] = f[t*nn+t+n] = 0;
	s += n;
	for (int i=0; i<n; i++)
		f[(i+n)*nn+s] = f[(t+n)*nn+i] = 0;
	n  = nn;
	maxflow();

	out.println(ALL>=0 && s-n/2!=t?"YES":"NO");
	
}
}







