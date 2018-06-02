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
//        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
 //       br = new BufferedReader(new FileReader("input.txt"));      
 //      out= new PrintWriter(new File("output.txt"));
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

double dist(double x, double y) {
	return Math.sqrt(x*x+y*y);
}
double eps = 1e-9;
public void solve() throws IOException {
	double[] x = new double[3];
	double[] y = new double[3];
	for (int i=0; i<3; i++) {
		x[i] = in.nextDouble();		
		y[i] =  in.nextDouble();
	}
	for (int i=0; i<3; i++) {
		double Ax = x[i], Ay = y[i];
		double Bx = x[(i+1)%3], By = y[(i+1)%3];
		double Cx = x[(i+2)%3], Cy = y[(i+2)%3];
		double ax = Bx-Ax, ay = By-Ay;
		double bx = Cx-Ax, by = Cy-Ay;
		double cx = Bx-Cx, cy = By-Cy;
		double a = dist(ax,ay);
		double b = dist(bx,by);
		double c = dist(cx,cy);
		double p = (a+b+c)/2;
	//	double s = Math.abs(ax*by-ay*bx)/4;
		double s = a*b/2;
		double d = p*p-4*s;
		if (d<0 && d>-eps) d = 0;
		if (d<0) continue;
		d = Math.sqrt(d);
		double x1 = (p+d)/2;
		double x2 = (p-d)/2;
		if (x1<-eps || x2<-eps) continue;
		if ((a>b) ^ (x1>x2)) {
			double q = x1; x1 = x2; x2 = q;
		}
		if (x1>a+eps || x2>b+eps) continue;
		ax *= x1/a;
		ay *= x1/a;
		
		bx *= x2/b;
		by *= x2/b;
		
	//	out.println(Math.abs(ax*by-ay*bx));
		out.printf(Locale.US, "YES\n%1.9f %1.9f\n%1.9f %1.9f",Ax+ax,Ay+ay,Ax+bx,Ay+by);
		return;
		
	}
	out.println("NO");

}      
} 



















