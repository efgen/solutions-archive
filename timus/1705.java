import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
//int inf = 1000000000;   
double eps = 1e-10;

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

public void solve() throws IOException {
	int tt = Integer.parseInt(br.readLine());
	int k = 1;
	while (tt-->0) {
		long n = Long.parseLong(br.readLine());
	//	long n = k++;
		long sq = Math.round(Math.sqrt(n));
		long l =  sq;
		long r = n;
		while (n/l-n/(l+1) > 1) l++;
		while (l<r) {
			long mid = (l+r+1)/2;
		    if (n/sq - n/mid == mid - sq) l = mid; else r = mid-1;
		}
		if (n==1) r = 2;
		if (n==2) r = 3;
		out.println(r);
	}
	
	
}
}







