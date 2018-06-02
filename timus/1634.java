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

int[] a = new int[100];
int N;
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b,a%b);
}
int[][] nok;
BigInteger[] fack = new BigInteger[100];
BigInteger res = BigInteger.valueOf(0);
public void divide(int n, int max, int k, int nok, BigInteger X) {
	if (n==0) {				
		for (int i=0; i<k;) {
			int l = 0, x = a[i];
			while (i+l<k && a[i+l]==x) l++;		
			X = X.multiply(fack[l]);
			i += l;
		}
		res = res.add(fack[N].divide(X).multiply(BigInteger.valueOf(nok)));
		return;
	}
	for (int i=Math.min(max, n); i>0; --i) {
		a[k] = i;			
		divide(n-i,i,k+1,nok*i/(gcd(nok,i)),X.multiply(BigInteger.valueOf(i)));
	}
}
public void solve() throws IOException {
	int n = in.nextInt();
	N = n;
	fack[0] = BigInteger.valueOf(1);
	for (int i=1; i<=n; i++) fack[i] = fack[i-1].multiply(BigInteger.valueOf(i));
	divide(n,n,0,1,BigInteger.ONE);
	out.println(res.divide(fack[n]));
}      
} 
