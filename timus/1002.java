import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.awt.geom.*;         
import java.util.regex.*;
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
int inf = 1000000000;
class Point implements Comparable<Point> {
	int id, len, x, y;
	Point (int xx, int yy, int l, int ii) {
		x = xx; y = yy; id = ii; len = l;
	}
	public int compareTo(Point o) {
		if (y>=0) return x-o.x; else return o.x-x;
	} 	
}
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b, a%b);
}
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
    	
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}


 int[] a = {2, 2, 2, 3, 3, 3, 4, 4, 1, 1, 5, 5, 6, 6, 0, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0};
public void solve() throws IOException {
	while (true) {
		String line = br.readLine().trim();
		if (line.equals("-1")) break;
		//out.println(a.length);
		char[] ph = ("."+line).toCharArray();
		int n = Integer.parseInt(br.readLine().trim());
		String[] w = new String[n];
		char[][] code = new char[n][];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			String s = br.readLine().trim().toLowerCase();
			sb.setLength(0);
			for (char c:s.toCharArray()) sb.append(""+a[c-'a']);
			code[i] = sb.toString().toCharArray();
			w[i] = s;
		}
		int len = ph.length-1;
		int[] d = new int[len+1];
		int[] p = new int[len+1];
		Arrays.fill(d, inf); d[0] = 0;
		for (int l=1; l<=len; l++)
			for (int i=0; i<n; i++) {
				if (code[i].length>l) continue;
				boolean ok = true;
				for (int j=0; j<code[i].length; j++)
					if (code[i][j] != ph[l-(code[i].length-j)+1]) {
						ok = false;
						break;
					}
				if (ok && d[l-code[i].length]+1<d[l]) {
					d[l] = d[l-code[i].length]+1;
					p[l] = i;
				}
			}
		if (d[len]<inf) {
			Stack<Integer> st = new Stack<Integer>();
			int t = len;
			while (t>0) {
				st.push(p[t]);
				t -= w[p[t]].length();
			}
			while (!st.isEmpty()) {
				out.print(w[st.pop()]);
				if (!st.isEmpty()) out.print(" "); else	out.println();
			}
		} else out.println("No solution.");
	}
			

}
}






 



