import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int n = nextInt();
  double[] x = new double[n];
  double[] y = new double[n];
  for (int i=0; i<n; i++) {
	  x[i] = nextInt();
	  y[i] = nextInt();
  }
	  
  double R = nextInt()-nextInt();
  int res = 0;
  if (R>=0) res = 1;
  double eps = 1e-3;
  for (int i=0; i<n; i++)
	  for (int j=i+1; j<n; j++) {
		  double xc = (x[i]+x[j])/2;
		  double yc = (y[i]+y[j])/2;
		  double a = y[j]-y[i];
		  double b = x[i]-x[j];
		  double dd = Math.hypot(a, b);
		  double d = Math.hypot(x[i]-xc, y[i]-yc);
		  if (d>R) continue;
		  d = Math.sqrt(R*R-d*d);
		  a = a*d/dd;
		  b = b*d/dd;
		  double X = xc+a;
		  double Y = xc+b;
		  int r = 0;
		  for (int k=0; k<n; k++) 
			  if (Math.hypot(x[k]-X, y[k]-Y)<=R+eps) r++; 
		  if (r>res) res = r;
		  r = 0; 
		  X = xc-a;
		  Y = yc-b;
		  for (int k=0; k<n; k++) 
			  if (Math.hypot(x[k]-X, y[k]-Y)<=R+eps) r++; 
		  if (r>res) res = r;		  
	  }
  out.println(res);
  out.close();    
}   

}


