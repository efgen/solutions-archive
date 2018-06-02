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
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
        br = new BufferedReader(new InputStreamReader(System.in));
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
	int n = nextInt();
	while (n-->0) {
		double a = nextInt();
		double b = nextInt();
		out.printf(Locale.US,"%1.6f\n",Math.max(0, (a-b+1)/(a+1)));
	}

	
}      
} 
