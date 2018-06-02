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




public void solve() throws IOException {
	int n = nextInt();
	int b = nextInt();
	if (b==0) {
		for (int i=0; i<n; i++) out.print('0');
	} else {
		out.print(1);
		int k = 1;
		for (int i=2; i<=n; i++) {
			if (k*100<b*i) {
				out.print('1');
				k++;
			} else out.print('0');
		}
	}
	
}
}









