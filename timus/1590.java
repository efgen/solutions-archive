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

int maxn = 10000+3;
int[][] next = new int[maxn][26];
int[] link = new int[maxn];
int[] len = new int[maxn];
int[] dp = new int[maxn];
int last = 0, sz = 0;
boolean[] f;
int[] ord;
int k = 0;
void dfs(int v) {
	f[v] = true;
	for (int c=0; c<26; c++)
		if (!f[next[v][c]]) dfs(next[v][c]);
	ord[k++] = v;
}

void init() {
	last = sz = 1;
}
void sa_extend(int c) {
	int nlast = ++sz;	
	int p = last;
	len[nlast] = len[last]+1;
	while (p>0 && next[p][c]==0) {
		next[p][c] = nlast;
		p = link[p];
	}
	if (p==0) link[nlast] = 1; else {
		int q = next[p][c];
		if (len[p]+1==len[q]) link[nlast] = q; else {
			int clone = ++sz;
			next[clone] = next[q].clone();
			len[clone] = len[p]+1;
			link[clone] = link[q];
			while (p>0 && next[p][c]==q) {
				next[p][c] = clone;
				p = link[p];
			}
			link[nlast] = clone;
			link[q] = clone;
			
		}
	}
	last = nlast;
}
public void solve() throws IOException {
	init();
	for (char c:br.readLine().toCharArray()) 
		sa_extend(c-'a');
	f = new boolean[sz+1];
	ord = new int[sz];
	f[0] = true;
	dfs(1);
	dp[1] = 1;
	for (int i=k-1; i>=0; i--) {
		int v = ord[i];
		for (int c=0; c<26; c++)
			if (next[v][c]>0) dp[next[v][c]] += dp[v];
		
	}
	int res = 0;
	for (int i=2; i<=sz; i++) res += dp[i];
	out.println(res);
		
	
}
} 











