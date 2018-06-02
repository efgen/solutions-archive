import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.util.regex.*;
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
    	//br = new BufferedReader(new InputStreamReader(System.in));
    	br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1")));
    	in = new Scanner(br);
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
long mod;
class Matrix {
	long[][] a = new long[n][n];
	Matrix mul(Matrix b) {
		Matrix res = new Matrix();
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++) {
				long t = 0;
				for (int k=0; k<n; k++)
					t += a[i][k]*b.a[k][j]%mod;
				res.a[i][j] = t%mod;
			}
		return res;
	}
	
	Matrix pow(Matrix x, int pow) {
		Matrix a = new Matrix();
		Matrix b = x;
		for (int i=0; i<n; i++) a.a[i][i] = 1%mod;
		while (true) {
			if ((pow&1)==1) a = a.mul(b);			
			pow >>= 1;
			if (pow>0) b = b.mul(b); else break;
		}
		return a;
	}
}
public void solve() throws IOException {
	int sz = nextInt();
	n = sz+1;
	int m = nextInt();
	int d = nextInt();
	mod = nextInt();
	Matrix a = new Matrix();
	for (int k=0; k<=sz; k++) {
		a.a[k][k] = (sz-k)*(m-2)%mod;
		if (k<sz) a.a[k][k+1] = (sz-k)%mod;
		if (k>0) a.a[k][k-1] = k*(m-1)%mod;
	}
	a = a.pow(a, d);
	int q = nextInt();
	int[][] p = new int[q][sz];
	for (int i=0; i<q; i++)
		for (int j=0; j<sz; j++)
			p[i][j] = nextInt();
	for (int i=0; i<q; i++) {
		for (int j=0; j<q; j++) {
			int cnt = 0;
			for (int k=0; k<sz; k++) if (p[i][k]==p[j][k]) cnt++;
			out.print(a.a[cnt][sz]);
			out.print(" ");
		}
		out.println();
	}
}
}









