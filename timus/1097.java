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

boolean intersect(int x0, int x1, int y0, int y1) {
	if (y0<x0) {
		int q = x0; x0 = y0; y0 = q;
		q = x1; x1 = y1; y1 = q;
	}
	return y0<x1;
}

public void solve() throws IOException {
	int L = nextInt();
	int R = nextInt();
	int n = nextInt();
	int[] sz = new int[n];
	int[] lvl = new int[n];
	int[] X = new int[n];
	int[] Y = new int[n];
	int[] x = new int[2*(n+1)];
	int[] y = new int[2*(n+1)];
	int k = 0;
	for (int i=0; i<n; i++) {
		lvl[i] = nextInt();
		sz[i] = nextInt();
		X[i] = nextInt();
		Y[i] = nextInt();
		x[k] = X[i]; y[k++] = Y[i];
		x[k] = X[i]+sz[i]; y[k++] = Y[i]+sz[i];
	}
	L++;
	x[k] = 1; y[k++] = 1;
	x[k] = L; y[k++] = L;
	int res = 256;
	int m = k;
	for (int i=0; i<m; i++)
		if (x[i]+R<=L)
		for (int j=0; j<m; j++) 
			if (y[j]+R<=L){			 
			int r = 1;
			for (k=0; k<n; k++)
				if (r<lvl[k] && intersect(x[i], x[i]+R, X[k], X[k]+sz[k]) && intersect(y[j], y[j]+R, Y[k], Y[k]+sz[k]))
					r = lvl[k];
			if (r<res) res = r;
		}
	if (res<=100) out.println(res); else out.println("IMPOSSIBLE");
}      
} 












