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

class Pacak implements Comparable<Pacak>{
	String name;
	int rank, msk;
	public Pacak(String s) {
		String[] ss = s.split(" ");
		name = ss[0];
		rank = Integer.parseInt(ss[2]);
		if (ss[1].charAt(0)=='a') msk = 3; else
			if (ss[1].charAt(0)=='t') msk = 2; else msk = 1;
	}
	


	public int compareTo(Pacak arg0) {		
		return rank-arg0.rank;
	}

}
int[] next, e, head;
int[] r, cl;
boolean[] f;
int M, cnt = 0;
void add(int x, int y) {
	cnt++;
	next[cnt] = head[x];
	head[x] = cnt;
	e[cnt] = y;
}
boolean dfs(int v) {
	if (v<0) return true;
	if (f[v]) return false; else f[v] = true;
	for (int t=head[v]; t>0; t = next[t])
		if (dfs(r[e[t]])) {
			r[e[t]] = v;
			return true;
		}
	return false;
}
void paint(int v, int c) {
	cl[v] = c;
	for (int t = head[v]; t>0; t = next[t])
		if (cl[e[t]]==0) paint(e[t], 3-c);
}
public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	Pacak[] src = new Pacak[n];
	int root1 = 0, root2 = 0;
	for (int i=0; i<n; i++) {
		src[i] = new Pacak(br.readLine());
		if (src[i].rank%2==0) root1 = i;
		if (src[i].rank%2==1) root2 = i;
	}
	M = n*n+1;
	next = new int[M];
	e = new int[M];
	head = new int[n];
	
	f = new boolean[n];
	r = new int[n];
	Arrays.fill(r, -1);
	for (int i=0; i<n; i++)
		for (int j=i+1; j<n; j++)
			if (Math.abs(src[i].rank-src[j].rank)==2 && ((src[i].msk|src[j].msk)==3)) {
				add(i, j); add(j, i);
			}
	cl = new int[n];
	for (int i=0; i<n; i++)
		if (cl[i]==0) paint(i, 1);

	for (int i=0; i<n; i++)
		if (cl[i]==1) {
			Arrays.fill(f, false);
			dfs(i);
		}
		
	int res = 0;
	for (int i=0; i<n; i++) if (r[i]>=0) res++;
	out.println(res);
	for (int i=0; i<n; i++)
		if (r[i]>=0) {
			int x = i, y = r[i];
			if (src[x].msk>src[y].msk) {
				int q = x; x = y; y = q;
			}
			if (src[x].msk==2) {
				int q = x; x = y; y = q;
			}
			out.println(src[x].name+" "+src[y].name);
		}}
}





