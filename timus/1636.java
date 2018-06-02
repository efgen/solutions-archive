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

public void solve() throws IOException {
	int t1 = nextInt();
	int t2 = nextInt();
	int r1 = 0, r2 = 0;
	int n = 10;
	for (int i=0; i<n; i++) r1 += 20*nextInt();
	if (t1<=t2-r1) out.println("No chance."); else out.println("Dirty debug :(");
}      
} 



















