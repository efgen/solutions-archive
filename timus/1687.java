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
boolean[][] a;
boolean[] f;
int[] r;
int n;
boolean dfs(int y) {
	if (y==0) return true;
	if (f[y]) return false;
	f[y] = true;
	
	for (int i=1; i<=n; i++)
		if (a[i][y] && dfs(r[i])) {
			r[i] = y;
			return true;
		}
	return false;
}
public void solve() throws IOException {
	n = nextInt();
	int m = nextInt();
	int[][] b = new int[n+1][m+1];
	for (int j=1; j<=m; j++) {
		int k = nextInt();
		while (k-->0) {
			int x = nextInt();
			b[x][j] = 1;
		}
	}
	f = new boolean[n+1];
	int k = nextInt();
	while (k-->0)
		f[nextInt()] = true;
	a = new boolean[n+1][m+1];
	int p = 0;
	for (int i=1; i<=n; i++)
		if (f[i]) {
			p++;
			for (int j=1; j<=m; j++) a[p][j] = b[i][j]==1;
		}
	n = p;
	r = new int[n+1];
	f = new boolean[m+1];
	
	
	/*for (int i=1; i<=n; i++) {
		for (int j=1; j<=m; j++)
			out.print(a[i][j]+" ");
		out.println();
	}*/
	
	for (int i=1; i<=m; i++) {
		Arrays.fill(f, false);
		dfs(i);
	}
	Arrays.fill(f, false);
	for (int i=1; i<=n; i++) f[r[i]] = true;
	TreeSet<Integer> v = new TreeSet<Integer>();
	TreeSet<Integer> t = new TreeSet<Integer>();
	for (int i=1; i<=m; i++) if (f[i]) v.add(i);
	int res = v.size();
	boolean[] good = new boolean[m+1];
	for (int j=1; j<=m; j++) {
		boolean ok = false;
		for (int i=1; i<=n; i++)
			if (a[i][j]) ok = true;
		good[j] = ok;
		if (f[j]) good[j] = false;
	}

	for (int i=1; i<=n; i++)
		for (int j=1; j<=m; j++)
			if (f[j] && a[i][j]) t.add(i);
	int N = t.size();
	for (int j=1; res<N && j<=m; j++)
		if (good[j]){
			res++;
			v.add(j);
		}
	out.println(res);
	for (int x:v) out.print(x+" ");
	
	
}
} 












