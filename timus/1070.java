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
double norm(double x) {
	double m = x-Math.floor(x);
	m *= 100;
	x = Math.floor(x)+m/60;
	return x;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  double t1 = norm(nextInt());
  double t2 = norm(nextInt());
  double t3 = norm(nextInt());
  double t4 = norm(nextInt());
  int res = 0;
  for (int dt=-5; dt<=5; dt++) {
	  double f1 = t2-t1-dt;
	  while (f1<0) f1 += 24;
	  while (f1>24) f1 -= 24;
	  
	  double f2 = t4-t3+dt;
	  while (f2<0) f2 += 24;
	  while (f2>24) f2 -= 24;
	  if (f1<=6 && f2<=6 && Math.abs(f1-f2)<=1.0/6) res = Math.abs(dt);
  }
  out.print(res);
	  
  
  out.close();    
}   
  
}