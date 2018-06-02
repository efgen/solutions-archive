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
	long d = nextInt();
	long x1 = nextInt();
	long y1 = nextInt();
	long x2 = nextInt();
	long y2 = nextInt();
	int n = nextInt();
	long t = x1*y2-x2*y1;
	while (n-->0) {
		long x = nextInt();
		long y = nextInt();
		boolean f = x*x+y*y<=d*d;
		f &= x1*y-x*y1 >= 0;
		f &= x*y2-x2*y >= 0;
		if (t==0) {
			if (x1*x+y1*y<0) f = false;
		}
		if (f) out.println("YES"); else out.println("NO");
	}
	
}
} 











