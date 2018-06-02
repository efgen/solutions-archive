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

double nextInt() throws IOException {
	in.nextToken();
	return in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);  
  while (true) {
	  in.nextToken();
	  if (in.ttype!=in.TT_NUMBER) break;	  
	  int n = (int)(in.nval);
	  n *= 2;
	  double[] x = new double[n];
	  double[] y = new double[n];
	  double[] a = new double[n];
	  for (int i=0; i<n; i++) {
		  x[i] = nextInt();
		  y[i] = nextInt();
	  }
	  for (int i=0; i<n; i++)
		  for (int j=0; j<n; j++)
			  a[i] += Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
	  Arrays.sort(a);	
	  double res = 0;
	  for (int i=n-1; i>0; i-=2) res += a[i]-a[i-1];
	  out.printf(Locale.US, "%1.3f\n",res/2);
  } 
  out.close();    
}   
  
}




