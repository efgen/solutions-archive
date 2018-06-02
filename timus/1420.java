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
	long a = nextInt();
	long b = nextInt();
	long c = nextInt();
	long d = nextInt();
	long dd = c*c+d*d;
	if (dd==0) {
		out.println(0);
		return;
	}
	long A = a*c+b*d;
	long B = -a*d+b*c;
	long ra = A/dd;
	long rb = B/dd;
	int res = 0;
	for (int i=-3; i<4; i++)
		for (int j=-3; j<4; j++) {
			long x = ra+i;
			long y = rb+j;
			long qa = (x*c-y*d) - a;
			long qb = (x*d+y*c) - b;
			if (qa*qa+qb*qb<dd) res++;
		}
	out.println(res);
	
}
} 











