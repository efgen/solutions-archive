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
      //  br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        //out= new PrintWriter(new File("output.txt"));
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
	int t = nextInt();
	while (t-->0) {
		int x = nextInt();
		int k = 0;
		while (x%2==0) {
			x >>= 1;
			k++;
		}
		boolean pr = BigInteger.valueOf(x).isProbablePrime(100);
		if (x==1) {
			if (k%2==1) out.println("YES"); else out.println("NO");
			continue;
		}
		if (k%2==0 ||(k%2==1 &&!pr)) out.println("YES"); else out.println("NO");
	}
}
} 












