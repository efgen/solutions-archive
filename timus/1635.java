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
     //   br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(System.out);      
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
	char[] s = ("."+br.readLine()).toCharArray();
	int n = s.length-1;
	boolean[][] a = new boolean[n+1][n+1];
	int[] d = new int[n+1];
	int[] p = new int[n+1];
	for (int i=1; i<=n; i++) a[i][i] = true;
	for (int i=1; i<n; i++) a[i][i+1] = s[i]==s[i+1];
	for (int len=3; len<=n; len++) {
		int l = 1, r = len;
		while (r<=n) {
			if (s[l]==s[r]) a[l][r] = a[l+1][r-1];
			l++; r++;
		}
	}
	Arrays.fill(d, inf);
	d[0] = 0;
	for (int i=1; i<=n; i++) {
		for (int j=1; j<=i; j++)
			if (a[j][i] && d[j-1]+1<d[i]) {
				d[i] = d[j-1]+1;
				p[i] = j-1;
			}
	}
	Stack<String> st = new Stack<String>();
	int i = n;
	while (i>0) {
		StringBuilder sb = new StringBuilder();
		for (int j=p[i]+1; j<=i; j++) sb.append(s[j]);
		st.push(sb.toString());
		i = p[i];
	}
	out.println(st.size());
	while (!st.isEmpty()) out.print(st.pop() + " ");
}      
} 



















