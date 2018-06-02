import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
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
//	new Main().run();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
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
long f(long x, long y, long n) {
	if (n==0) return 0;
	long d = y-x;
	if (d==0) return n/x;
	long K = (x+d-2)/d;
	if (K==0) K = 1;
	BigInteger N = BigInteger.valueOf(K).multiply(BigInteger.valueOf(x));
	long res = 0;
	if (N.compareTo(BigInteger.valueOf(n))<=0) {
		res += n-N.longValue()+1;
		n = N.longValue()-1;
	}
	K = n/y;
	res += K + K*(K+1)/2*d;
	N = BigInteger.valueOf(K+1).multiply(BigInteger.valueOf(x));
	if (N.compareTo(BigInteger.valueOf(n))<=0) res += n-N.longValue()+1;
	return res;
	
}
public void solve() throws IOException {
	for (int i=0; i<1; i++) {
		long x = in.nextLong();
		long y = in.nextLong();
		long l = in.nextLong();
		long r = in.nextLong();
		out.println(f(x, y, r)-f(x, y, l-1));
	}

	
}
  
}
















 
 
  