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
//	new Main().run();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	//in = new Scanner(br);
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
long sq(long x) {return x*x;}
int dummy(int a, int b, int n) {
	int res = 0;
	for (int i=0; i<n; i++)
		for (int j=i+1; j<n; j++)
			if (i/a==j/a && i/b!=j/b) res++;
	return res;
}
public void solve() throws IOException {
	int a = nextInt();
	int b = nextInt();
	int n = nextInt();
	//out.println(dummy(a, b, n));
	long res = 0;
	for (int i=0; i<n; i+=a) {
		int k = (i/b+1)*b;
		int L = Math.min(i+a, n);
		if (k<L) {
			res += sq(L-i);
			int p = i;
			while (k<L) {
				res -= sq(k-p);
				p = k;
				k += b;
			}
			res -= sq(L-p);
		}
	}
	out.print(res>>1);
	

	
}
  
}
















 
 
  