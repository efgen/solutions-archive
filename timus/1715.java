import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   

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
	
    	
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();        
    
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}

int N, M, n, m;
char[][]  src, a;
int[][] f;
char[] cl = {'B', 'G', 'R', 'W', 'Y'};
int px, py;
int[] cnt;
int dfs(int x, int y, int k, char c) {
	if (x<0 || y<0 || x>=n || y>=m) return 0;
	if (a[x][y]!=c || f[x][y]!=0 || a[x][y]=='.') return 0;
	f[x][y] = k;	
	return 1+dfs(x+1, y, k, c)+dfs(x-1, y, k, c)+dfs(x, y+1, k, c)+dfs(x, y-1, k, c);
}
void dfs2(int x, int y, int k) {
	if (x<0 || y<0 || x>=n || y>=m) return;
	if (f[x][y]!=k || a[x][y]=='.') return;
	a[x][y] = '.';	
	dfs2(x+1, y, k);
	dfs2(x-1, y, k);
	dfs2(x, y+1, k);
	dfs2(x, y-1, k);
}
public void solve() throws IOException {
	String[] ss = br.readLine().split(" ");
	N =  Integer.parseInt(ss[0]);
	M =  Integer.parseInt(ss[1]);
	cnt = new int[N*M];
	src = new char[N][];
	for (int i=0; i<N; i++) src[N-i-1] = br.readLine().toCharArray();
	for (char c:cl) {
		n = N; m = M;
		a = new char[n][m];	
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++)
				a[i][j] = src[i][j];
		
		boolean exs = false;
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++)
				if (a[i][j]!='.' && a[i][j]==c) exs = true;
		int res = 0;
		if (!exs) continue;
		while (n>0 && m>0) {		
			f = new int[n][m];
			int kk = 0;
			int r = 0;
			for (int i=0; i<n; i++)
				for (int j=0; j<m; j++)
					if (f[i][j]==0 && (exs?(a[i][j]!=c):true) && a[i][j]!='.') {
						int val = dfs(i, j, ++kk, a[i][j]);
						if (val>r) {
							r = val;
							px = i; py = j;
						}					
					}
			if (r<2) {
				if (exs) {
					exs = false;
					continue;
				} else
				break;
			}
			//out.print(r+" ");
			res += r*(r-1);
			dfs2(px, py, f[px][py]);
			for (int i=1; i<n; i++)
				for (int j=0; j<m; j++)
					if (a[i-1][j]=='.') {
						int t = i-1;
						while (t>=0 && a[t][j]=='.') {
							a[t][j] = a[t+1][j];
							a[t+1][j] = '.';
							t--;
						}
					}
			for (int i=n-1; i>=0; --i) {
				boolean emp = true;
				for (int j=0; j<m; j++) emp &= a[i][j]=='.';
				if (emp) {
					for (int k=i+1; k<n; k++)
						for (int j=0; j<m; j++)
							a[k-1][j] =  a[k][j];
					n--;
				}
			}
			
			for (int i=m-1; i>=0; --i) {
				boolean emp = true;
				for (int j=0; j<n; j++) emp &= a[j][i]=='.';
				if (emp) {
					for (int k=i+1; k<m; k++)
						for (int j=0; j<n; j++)
							a[j][k-1] =  a[j][k];
					m--;
				}
			}
			exs = true;
		}
		out.println(c+": "+res);
	}
		
}
}





