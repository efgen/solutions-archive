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
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
    //	br = new BufferedReader(new FileReader("input.txt"));      
     //  out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
  //  	out = new PrintWriter(System.out);    	
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
int[] p;
int[][] res;
boolean[] f;
void dfs(int v) {	
	f[v] = true;
	for (int i=0; i<n; i++)
		if (a[v][i])
			if (!f[i]){ p[i] = v; dfs(i); }else 
				if (i!=p[v]) res[v][i] = res[i][v] = 1;
}
public void solve() throws IOException {
	n = Integer.parseInt(br.readLine());
	String[] ss  = br.readLine().split(" ");
	int del = Integer.parseInt(ss[0]);
	int add = Integer.parseInt(ss[1]);
	a = new boolean[n][n];
	for (int i=0; i<n; i++) {
		char[] s = br.readLine().toCharArray();
		for (int j=0; j<n; j++)
			a[i][j] = s[j] == '1';
	}
	res = new int[n][n];
	f = new boolean[n];
	p = new int[n];
	Arrays.fill(p, -1);
	for (int i=0; i<n; i++)
		if (!f[i]) {
			dfs(i);
			if (i>0) res[0][i] = res[i][0] = 2;		
		}
	long z = 0;
	for (int i=0; i<n; i++)
		for (int j=i+1; j<n; j++)
			if (res[i][j]==1) z+=del; else
				if (res[i][j]==2) z += add;
	out.println(z);
	for (int i=0; i<n; i++) {
		for (int j=0; j<n; j++)
			if (res[i][j]==1) out.print('d'); else
				if (res[i][j]==2) out.print('a'); else out.print('0');
		out.println();
	}
		
	
}      
} 



















