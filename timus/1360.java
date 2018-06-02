import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  double cx = in.nextDouble();
  double cy = in.nextDouble();
  double r = in.nextDouble();
  double t = Math.asin(cx);
  double u = 0;
  int n = 0;
  if (t<0) n++;
  while (true) {
	   if (n%2==0) u = t+Math.PI*n; else u = -t+Math.PI*n;
	   if (u>1000000) break;
	   if (Math.abs(Math.cos(u*u)-cy)<=r) {
		   out.println(u*u);
		//   out.println(n);
		//   out.println(Math.sin(u));
		//   out.println(Math.cos(u*u));
		   
		   in.close(); out.close();
		   return;
	   }
	   n++;
  }
  out.print("FAIL");
  in.close(); out.close();
}

}
