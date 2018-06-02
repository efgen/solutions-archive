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


public void solve() throws IOException {
	int n = nextInt();
	int m = nextInt();
	int k = nextInt();
	TreeSet<Integer>[] h = new TreeSet[n];
	TreeSet<Integer>[] v = new TreeSet[m];
	TreeSet<Integer> sng = new TreeSet<Integer>();
	for (int i=0; i<n; i++) {
		h[i] = new TreeSet<Integer>();
		h[i].add(m+1);
	}
	for (int i=0; i<m; i++) {
		v[i] = new TreeSet<Integer>();
		v[i].add(n+1);
	}
	
	while (k-->0) {
		int x = nextInt();
		int y = nextInt();
		h[x-1].add(y);
		v[y-1].add(x);		
	}
	int res = 0;
	for (int i=0; i<n; i++) {
		int p = 0;
		for (int x:h[i]) {
			if (x!=p+1) {				
				if (x-p==2) sng.add(i*m+x-2); else res++;
			}
			p = x;
		}
	}
	
	for (int i=0; i<m; i++) {
		int p = 0;
		for (int x:v[i]) {
			if (x!=p+1) {
				
				if (x-p==2) { if (sng.contains((x-2)*m+i)) res++; } else res++;
			}
			p = x;
		}
	}
//	out.println(sng);
	out.println(res);

}
}











