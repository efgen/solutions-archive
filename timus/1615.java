import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.util.regex.*;
public class Main implements Runnable{
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
//	new Main().run();
}

public void run()  {      
    try {          
    	//br = new BufferedReader(new InputStreamReader(System.in));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new OutputStreamWriter(System.out));
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}



long gcd(long a, long b) {
	if (b==0) return a; else return gcd(b, a%b);
}
public void solve() throws IOException {
	long n = nextInt();
	long x = n*n - (n-1)*(n-2)/2;
	long y = (2*n-1)*(n);
	long d = gcd(x, y);
	out.println(x/d+"/"+y/d);
}
}









