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
int nextD() throws IOException{      
    ST.nextToken();      
    return (int) Math.floor(ST.nval*100+0.5);     
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
BigInteger f(int n) {
	if (n%2==0) {
		n /=2;
		BigInteger res = BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE).shiftLeft(2);
		return res;
	} else {	
		if (n==1) return BigInteger.ONE;
		n /= 2;
		BigInteger res = BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE).add(BigInteger.ONE.shiftLeft(n-1)).shiftLeft(2);
		return res;
	}
}
public void solve() throws IOException {
	out.println(f(nextInt()));
}
}











