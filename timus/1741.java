import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
long inf = 1000000000000000000l;   


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
//    	br = new BufferedReader(new FileReader(new File(filename+".in")));
//   	out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
//    	br = new BufferedReader(new FileReader(new File("input.txt")));
//    	out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
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
class Edge {
	int x, v, t;
	public Edge(int xx, int vv, int tt) {
		x = xx; v = vv; t = tt;
	}
}
public void solve() throws IOException {
	int n = nextInt();
	int m = nextInt();
	Vector<Edge>[] e = new Vector[n+1];
	for (int i=1; i<=n; i++) e[i] = new Vector<Edge>();
	while (m-->0) {
		int x = nextInt();
		int y = nextInt();
		int v = nextInt();
		String tt = next();
		int t = 0;
		if (tt.charAt(0)=='P') t = 0; 
		if (tt.charAt(0)=='C') t = 1; 
		if (tt.charAt(0)=='L') t = 2;			
		e[x].add(new Edge(y, v, t));
	}
	long[] dp = new long[n+1];
	long[] dl = new long[n+1];
	Arrays.fill(dp, inf);
	Arrays.fill(dl, inf);
	dl[1] = 0;
	for (int i=1; i<=n; i++)
		for (Edge p:e[i]) 
			if (p.t==0) dp[p.x] = Math.min(dp[p.x], Math.min(dp[i], dl[i])+p.v); else
				if (p.t==1) {
					dp[p.x] = Math.min(dp[p.x], dp[i]+p.v);
					dl[p.x] = Math.min(dl[p.x], dl[i]+p.v);
				} else 
					dl[p.x] = Math.min(dl[p.x], dl[i]+p.v);
	long res = Math.min(dp[n], dl[n]);
	if (res<inf) {
		out.println("Online");
		out.println(res);
	} else {
		out.println("Offline");
	}
	

}
}





