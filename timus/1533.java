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



boolean[][] a;
int n;
int[] res;
boolean[] f;
boolean dfs(int v) {
	if (v<0) return true;
	if (f[v]) return false;
	f[v] = true;
	for (int i=0; i<n; i++)
		if (a[v][i] && dfs(res[i])) {
			res[i] = v;
			return true;
		}
	return false;
}

boolean[][] route;
int kk;
int[] ub;
boolean[] inans;
int[] size;
boolean gen(int m) {
	if (m==kk) return true;
	if (size[m]==1) return gen(m+1);
	for (int i=0; i<n; i++)
		if (ub[i]==0 && route[m][i]) {
			inans[i] = true;
			for (int j=0; j<n; j++) if (a[i][j]) ub[j]++;
			if (gen(m+1)) return true;
			inans[i] = false;
			for (int j=0; j<n; j++) if (a[i][j]) ub[j]--;
		}
	return false;
}
public void solve() throws IOException {
	n = nextInt();
	a = new boolean[n][n];
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			a[j][i] = nextInt()==1;
	
	

	for (int k=0; k<n; k++)
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				a[i][j] |= a[i][k] && a[k][j];
	
	f = new boolean[n];
	res = new int[n];
	Arrays.fill(res, -1);
	kk = 0;
	for (int i=0; i<n; i++) {
		Arrays.fill(f, false);
		if (dfs(i)) kk++;

	
	}
	
	

	route = new boolean[n][n];
	int[] nr = new int[n];
	int[] inv = new int[n];
	Arrays.fill(inv, -1);
	for (int i=0; i<n; i++)
		if (res[i]>=0) inv[res[i]] = i;

	kk = 0;
	Arrays.fill(f, false);
	for (int i=0; i<n; i++) if (!f[i]){
		int v = i;
		while (v>=0) {
			nr[v] = kk;
			f[v] = true;
			route[kk][v] = true;
			v = res[v];
			
		}
		v = i;
		while (v>=0) {
			nr[v] = kk;
			f[v] = true;
			route[kk][v] = true;
			v = inv[v];
			
		}
		kk++;
		
	}
	
/*	TreeSet<Integer> t = new TreeSet<Integer>();
	boolean[] use = new boolean[kk];
	Arrays.fill(f, false);

	for (int i=0; i<n; i++) 
	if (!f[i]){
		boolean ok = true;
		for (int k=0; k<kk; k++)
			if (!use[k] && k!=nr[i]) {
				boolean fl = true;
				for (int j=0; j<n; j++)
					if (route[k][j])
						if (!(a[i][j] || a[j][i])) fl = false;
				if (fl) ok = false;
			}
		if (!ok) continue;
		t.add(i);
		use[nr[i]] = true;
		f[i] = true;
		for (int j=0; j<n; j++)
			if (a[i][j] || a[j][i]) f[j] = true;
	}
	if (t.size()!=kk) {
		for (int i=0; i<n; i++) {
			n++;
		}
	}
	out.println(t.size());
	for (int x:t) out.print((x+1)+" ");*/
	inans = new boolean[n];
	ub = new int[n];
	Arrays.fill(f, false);
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			a[i][j] |= a[j][i];
	size = new int[kk];
	for (int i=0; i<kk; i++) {
		int v = -1;
		for (int j=0; j<n; j++)
			if (route[i][j]) { size[i]++; v = j; }
		if (size[i]==1) {
			for (int j=0; j<n; j++)
				if (a[v][j]) ub[j]++;
			inans[v] = true;
		}
	}

	gen(0);
	out.println(kk);
	for (int i=0; i<n; i++) if (inans[i]) out.print((i+1)+" ");

	
}
}







