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
    	//br = new BufferedReader(new FileReader(new File(filename+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}
int[] a = new int[7];
int[][] v = new int[7][7];
boolean[][] w = new boolean[7][7];
boolean[] f = new boolean[7];
int res = Integer.MAX_VALUE;
Vector<Integer> x = new Vector<Integer>();
Vector<Integer> y = new Vector<Integer>();
Vector<Integer> vx = new Vector<Integer>();
Vector<Integer> vy = new Vector<Integer>();
void dfs(int t) {
	f[t] = true;
	for (int i=1; i<=6; i++)
		if (!f[i] && v[t][i]>0) dfs(i);
}
void test(int s) {
	Arrays.fill(f, false);
	for (int i=1; i<7; i++)
		if (a[i]>0) {
			dfs(i);
			break;
		}
	for (int i=1; i<7; i++)
		if (a[i]>0 && !f[i]) return;
	int k = 0;
	for (int i=1; i<7; i++)
		 k += a[i]%2;
	
	if (k==0 || k==2) {
		vx = (Vector<Integer>)x.clone();
		vy = (Vector<Integer>)y.clone();
		res = s;
	}	  
	
}
void gen(int k, int s) {	
	if (s>=res) return;
	test(s);
	if (k>4) return;
	for (int i=1; i<7; i++)
		for (int j=i+1; j<7; j++) {
			x.add(i);
			y.add(j);
			v[i][j]++; v[j][i]++;
			a[i]++; a[j]++;
			gen(k+1, s+i+j);
			v[i][j]--; v[j][i]--;
			a[i]--; a[j]--;
			x.remove(x.size()-1);
			y.remove(y.size()-1);
		}
}
public void solve() throws IOException {
	int n = nextInt();
	while (n-->0) {
		int x = nextInt();
		int y = nextInt();
		a[x]++;
		a[y]++;
		v[x][y]++;
		v[y][x]++;
	}
	gen(0, 0);
	out.println(res);
	n = vx.size();
	out.println(n);
	for (int i=0; i<n; i++) out.println(vx.elementAt(i)+" "+vy.elementAt(i));
	
}
}





