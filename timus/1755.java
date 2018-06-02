import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-9;

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
double a1, a2, b1, b2, n, m;
double g(double x, double y) {
	double v1 = a2*x+b2*y;
	double v2 = a2*(n-x)+b2*(m-y);
	if (Math.abs(v1-v2)<eps) {
		return Math.max(a1*x+b1*y, a1*(n-x)+b1*(m-y));
	}
	if (v1<v2) 
		return a1*x+b1*y; 
	else
		return a1*(n-x)+b1*(m-y);
}
double farg(double x) {
	double l = 0, r = m;
	while (r-l>eps) {
		double m1 = l+(r-l)/3;
		double m2 = r-(r-l)/3;
		if (g(x, m1)<g(x, m2)) l = m1; else r = m2;
	}
	return (l+r)/2;
}
double f(double x) {
	return g(x, farg(x));
}
public void solve() throws IOException {
	a1 = nextD();
	b1 = nextD();
	a2 = nextD();
	b2 = nextD();
	n = nextD();
	m = nextD();
	double lx = 0, rx = n;
	while (rx-lx>eps) {
		double m1 = lx+(rx-lx)/3;
		double m2 = rx-(rx-lx)/3;
		if (f(m1)<f(m2)) lx = m1; else rx = m2;
	}
	double x = (lx+rx)/2;
	out.println(x+" "+farg(x));
	
}
}






