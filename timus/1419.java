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


int n;
Vector<Integer>[] a;
int[] pr, d;
int[] low;
int time;
boolean ok = true;
int sz = 0;
void dfs(int v) {
	d[v] = low[v] = ++time;
	sz++;
	for (int x:a[v])
		if (d[x]==0) {
			pr[x] = v;
			dfs(x);
			low[v] = Math.min(low[v], low[x]);
			if (low[x]==d[x]) ok = false;
		} else
			if (x!=pr[v]) low[v] = Math.min(low[v], d[x]);
}
public void solve() throws IOException {
	String[] ss = br.readLine().split(" ");
	int w = Integer.parseInt(ss[0]);
	int h = Integer.parseInt(ss[1]);
	char[][] map = new char[h+2][w+2];
	int[][] nums = new int[h+2][w+2];
	for (char[] aa:map) Arrays.fill(aa, ' ');
	int n = 0;
	for (int i=1; i<=h; i++) {
		String str = br.readLine();
		while (str.length()<w) str += " ";
		char[] s = str.toCharArray();
	
	//	char[] s = br.readLine().toCharArray();
		if (s.length!=w) {
			for (int k=0; k<inf; k++) {
				inf++;
			}
		}
		for (int j=1; j<=w; j++) {
			map[i][j] = s[j-1];
			if (map[i][j]=='O') nums[i][j] = ++n;
		}
	}
	a = new Vector[n+1];
	for (int i=1; i<=n; i++)
		a[i] = new Vector<Integer>();
	for (int i=1; i<=h; i++) {
		for (int j=1; j<=w; j++)
			if (map[i][j]=='O') {
				int v = nums[i][j];
				if (map[i-1][j]=='|' && nums[i-2][j]>0) a[v].add(nums[i-2][j]);
				if (map[i+1][j]=='|' && nums[i+2][j]>0) a[v].add(nums[i+2][j]);
				
				if (map[i][j-1]=='-' && nums[i][j-2]>0) a[v].add(nums[i][j-2]);
				if (map[i][j+1]=='-' && nums[i][j+2]>0) a[v].add(nums[i][j+2]);
				
				if (map[i-1][j+1]=='/' && nums[i-2][j+2]>0) a[v].add(nums[i-2][j+2]);
				if (map[i+1][j-1]=='/' && nums[i+2][j-2]>0) a[v].add(nums[i+2][j-2]);				

				if (map[i-1][j-1]=='\\' && nums[i-2][j-2]>0) a[v].add(nums[i-2][j-2]);
				if (map[i+1][j+1]=='\\' && nums[i+2][j+2]>0) a[v].add(nums[i+2][j+2]);
			}
	}
	for (int i=1; i<=n; i++) ok &= a[i].size()==3;
	low = new int[n+1];
	d = new int[n+1];
	pr = new int[n+1];
	dfs(1);
	ok &= sz==n;
	for (int i=1; i<=h; i++)
		for (int j=1; j<=w; j++) {
			if (map[i][j]=='|') ok &= map[i-1][j]=='O' && map[i+1][j] == 'O';
			if (map[i][j]=='-') ok &= map[i][j-1]=='O' && map[i][j+1] == 'O';
			if (map[i][j]=='/') ok &= map[i-1][j+1]=='O' && map[i+1][j-1] == 'O';
			if (map[i][j]=='\\') ok &= map[i-1][j-1]=='O' && map[i+1][j+1] == 'O';
		}
	for (int i=1; i<=h; i++)
		for (int j=1; j<=w; j++)
			if (i%2+j%2==2) ok &= map[i][j]=='O'; else ok &= map[i][j]!='O';
	for (int i=1; i<=h; i++)
		for (int j=1; j<=w; j++)
			ok &= map[i][j]=='O' || map[i][j]==' ' || map[i][j]=='|' || map[i][j]=='-'|| map[i][j]=='\\' || map[i][j]=='/';
	if (ok) out.println("Island world"); else out.println("Just a picture");
	
}
}







