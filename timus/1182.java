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

int n;
boolean[][] a;
int[] col;
int sz1 = 0, sz2 = 0;
boolean ckl = false;
void dfs(int v, int c) {
	col[v] = c;
	if (c>0) sz1++; else sz2++;
	for (int i=0; i<n; i++)
		if (a[v][i] || a[i][v]) {
			if (col[i]==0) dfs(i, -c); else 
				if (col[i]==col[v]) ckl = true;
		}
}
public void solve() throws IOException {
	n = Integer.parseInt(br.readLine());
	a = new boolean[n][n];
	for (boolean[] aa: a) Arrays.fill(aa, true);
	col = new int[n];
	for (int i=0; i<n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		a[i][i] = false;
		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			if (x==0) break;
			--x;
			a[i][x] = false;
		}
	}
	Vector<Integer> part1 = new Vector<Integer>();
	Vector<Integer> part2 = new Vector<Integer>();
	col = new int[n];
	int cc = 0; 
	for (int i=0; i<n; i++)
		if (col[i]==0) {
			++cc;
			sz1 = 0; sz2 = 0;
			dfs(i, cc);
			part1.add(sz1);
			part2.add(sz2);
		}
	if (ckl) {
		out.println("No solution");
		return;
	}
	int[][][] dp = new int[n+1][n+1][n+1];
	dp[0][0][0] = Integer.MAX_VALUE;
	for (int k=1; k<=part1.size(); k++) {
		int x = part1.elementAt(k-1);
		int y = part2.elementAt(k-1);
		//out.println(x+" "+y);
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (dp[k-1][i][j]!=0) {
					dp[k][i+x][j+y] = k;
					dp[k][i+y][j+x] = -k;
				}
	}
	Vector<Integer> ans1 = new Vector<Integer>();
	Vector<Integer> ans2 = new Vector<Integer>();
	int bx = n, by = 0;
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			if (dp[part1.size()][i][j]!=0 && Math.abs(i-j)<Math.abs(bx-by)) {
				bx = i; by = j;
			}
	for (int k=part1.size(); k>0; --k) {
		int r = dp[k][bx][by];
		for (int i=0; i<n; i++) 
		if (Math.abs(col[i])==k){
			if (col[i]==k ^ r<0) ans1.add(i); else  ans2.add(i);
		}
		
		if (r>0) {
			bx -= part1.elementAt(k-1);
			by -= part2.elementAt(k-1);
		} else {
			bx -= part2.elementAt(k-1);
			by -= part1.elementAt(k-1);
		}
	}
	
	
	out.print(ans1.size()+" ");
	for (int x:ans1) out.print((x+1)+" ");
	out.println();
	out.print(ans2.size()+" ");
	for (int x:ans2) out.print((x+1)+" "); 
	
}
}











