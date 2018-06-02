import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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
boolean ok(BigInteger x) {
	String s = x.multiply(x).subtract(x).toString();
	for (int i=x.toString().length(); i>0; --i)
		if (s.charAt(s.length()-i)!='0') return false;
	return true;
}

public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	int[] a = new int[n];
	int[] b = new int[n];
	boolean[] c = new boolean[n];
	TreeSet<Integer> t = new TreeSet<Integer>();
	for (int i=0; i<n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		a[i] = Integer.parseInt(st.nextToken());
		b[i] = Integer.parseInt(st.nextToken());
		c[i] = st.nextToken().charAt(0)=='w';
		t.add(a[i]); t.add(b[i]);
	}
	t.add(0);
	t.add(1000000000);
	int best = -1, bx = -1, by = -1;
	Integer[] x = t.toArray(new Integer[0]);
	int sz = x.length;
	boolean[] col = new boolean[sz];
	for (int i=1; i<x.length; i++) {
		int l = x[i-1], r = x[i];
		double mid = (l+r)/2.0;
		col[i-1] = true;
		for (int j=0; j<n; j++)
			if (mid>=a[j] && mid<=b[j]) col[i-1] = c[j];
		
	}
	for (int i=0; i<sz-1; ) {
		if (col[i]) {
			int l = x[i];
			while (i<sz-1 && col[i]) i++;
			if (x[i]-l>best) {
				best = x[i]-l;
				bx = l; by = x[i];
			}
		} else i++;
	}
	out.println(bx+" "+by);

}
}











