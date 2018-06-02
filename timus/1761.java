import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-9;

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

boolean ok(char[] s, int l, int r) {
	while (l<r) {
		if (s[l++]!=s[r--]) return false;
	}
	return true;
}
int f(char[] s) {
	int res = 0;
	for (int len=1; len<=s.length; len++) {
		int l = 0, r = len-1;
		boolean ff = false;
		while (r<s.length) {
			if (ok(s,l,r)) {
				ff = true; break;
			}
			l++; r++;
		}
		if (ff) res = len;
	}
	return res;
}
int ff(char[] s) {
	int n = 0;
	for (char c:s) n = 2*n+c-'0';
	StringBuilder sb = new StringBuilder();
	for (int i=1; i<=n; i++) {
		sb.append(BigInteger.valueOf(i).toString(2));
	}
	return f(sb.toString().toCharArray());
}
public void solve() throws IOException {
	char[] s = br.readLine().toCharArray();
	int n = s.length;
	if (n<=6) {
		out.println(ff(s));
	} else {
		for (int i=0; i<n; i++) s[i] -= '0';
		for (int i=1; i<=3; i++) {
			int p = s.length-i;
			while (s[p]==0) {
				s[p] = 1;
				p--;
			}
			s[p] = 0;
		}
		int p = 0;
		while (s[p]==0) {
			p++; n--;
		}
		out.println(13+3*(n-5));
	}
	/*{
		
		n = n.subtract(BigInteger.valueOf(7));
		int k = n.bitLength()-5;
		out.println(13+3*k);
	}*/
	
}
}






