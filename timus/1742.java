import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StringTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
int nextInt() throws IOException{      
          
    return Integer.parseInt(next());      
}
long nextLong() throws IOException{    
    
    return Long.parseLong(next());      
}      
String next() throws IOException{      
    while (ST==null || !ST.hasMoreTokens()) {
    	String line = br.readLine();
    	if (line==null) return null;
    	ST  = new StringTokenizer(line);
    }
    return ST.nextToken();
}      
double nextD() throws IOException{      
    return Double.parseDouble(next());      
}      
public static void main(String[] args) throws IOException {       
   new Thread(new Main()).start();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
    	//in = new Scanner(br);
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}
int[] go;
int[] f;
Vector<Integer>[] inv;
int cklen;
int ends;
int k;
void dfs(int v) {	
	f[v] = ++k;
	
	if (f[go[v]]==0) dfs(go[v]); else {
		if (cklen==0)
			cklen = k+1-f[go[v]]; 
	}
	if (inv[v].size()==0) ends++;
	for (int x:inv[v]) if (f[x]==0) 
		dfs(x);
	
}
public void solve() throws IOException {
	int n = nextInt();
	go = new int[n];
	f = new int[n];
	inv = new Vector[n];
	for (int i=0; i<n; i++) inv[i] = new Vector<Integer>();
	for (int i=0; i<n; i++) {
		go[i] = nextInt()-1;
		inv[go[i]].add(i);
	}
	int min = 0, max = 0;
	for (int i=0; i<n; i++) if (inv[i].size()==0 && f[i]==0){
		cklen = 0;
		ends = 0;
		k = 0;
		dfs(i);
		min += ends;
		max += k-cklen+1; 
	}
	for (int i=0; i<n; i++) if (f[i]==0) {
		dfs(i);
		min++; max++;
	}
	out.println(min+" "+max);
}
  
}













 
 
  