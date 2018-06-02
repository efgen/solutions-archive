import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  double x = in.nextDouble();
  double y = in.nextDouble();
  int n = in.nextInt();
  int s = (int)Math.floor(n*Math.min((x+0.05),10)-0.00001); 
  if (x==10) s = 10*n;
  int X = (int)Math.round(10*x);
  int Y = (int)Math.round(10*y);
  /*int k = 0;
  if (y<10) {
	  y = Math.min(10, y+0.05);
	  k = (int)Math.ceil((s-n*y)/(y-1)+0.00001);
  }
  out.println(k);*/
  int L = 0, R = 200000000;
  while (L<R) {
	  int k = (L+R)/2;
	  int t = (int)Math.round((s+k)*10.0/(n+k));
	  if (t<=Y) R = k; else L = k+1;
  }
  out.print(R);
  in.close(); out.close();  
}
}
