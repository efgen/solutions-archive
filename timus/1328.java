import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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

int w, h, x0, y0;
double angle = 1e+100;
long len = Long.MAX_VALUE;
long sqr(long x) {
	return x*x;
}
void gen(int x, int y, int n, int t) {
	//out.println(x+" "+y);
	if (n==0) {		
		long vv = sqr(x-x0)+sqr(y-y0);
		double alf = Math.atan2(y-y0, x-x0);
		if (alf<0) alf += 2*Math.PI;
		if (vv<len || (vv==len && alf<angle)) {
			len = vv;
			angle = alf;
		}
		return;
	}
	int xx = ((x%w)+w)%w;
	int yy = ((y%h)+h)%h;
	if (t==0) {
		gen(x-2*xx, y, n-1, 0);
		gen(x, y-2*yy, n-1, 0);	
	}
	
	if (t==1) {
		gen(x-2*xx, y, n-1, 1);
		gen(x, y+2*(h-yy), n-1, 1);	
	}
	
	if (t==2) {
		gen(x+2*(w-xx), y, n-1, 2);
		gen(x, y+2*(h-yy), n-1, 2);
	}
	if (t==3) {
		gen(x+2*(w-xx), y, n-1, 3);
		gen(x, y-2*yy, n-1, 3);	
	}
	
	
	
}
public void solve() throws IOException {
	w = nextInt();
	h = nextInt();
	int n = nextInt();
	x0 = nextInt();
	y0 = nextInt();

	int x1 = nextInt();
	int y1 = nextInt();
	gen(x1, y1, n, 0);
	gen(x1, y1, n, 1);
	gen(x1, y1, n, 2);
	gen(x1, y1, n, 3);
	out.printf(Locale.US, "%1.2f",angle*180/Math.PI);
}
}







