import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
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
  int n = nextInt();
  int k = nextInt();
  double u = nextD();
  double v = nextD();
  double best = (n-1)*u;
  int res = 1;
  double eps = 1e-9;
  for (int t=n; t>=2; t--) {
	  double tt = Math.max((k-1)*v+15,(n-t)*u)+5+2*(t-1)*v;
	  if (tt+eps<best) {
		  best = tt;
		  res = t;
	  }
  }
  out.println(res);
  out.close();    
}   

}
