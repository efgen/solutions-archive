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
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
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


public void solve() throws IOException {
	int n = nextInt();
	int k = nextInt();
	int m = nextInt();
	m = n+1;
	out.println("YES");
	while (k-->0) {
		int t = nextInt();
		int x = 0;
		while (t-->0) x += nextInt();
		out.println(x%m+1);
	}
		
	
}
  
}
















 
 
  