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
  int T = in.nextInt();
  double R = in.nextInt();
  int n = in.nextInt();
  if (T==1) R *= 2; else
	  if (T==2) R *= Math.sqrt(2);
		  
  
  int res = 0;
  while (n-->0) {
	  int t = in.nextInt();
	  double r = in.nextInt();
	  if (t==1) r *= 2; else
		  if (t==3) r *= Math.sqrt(3)/2;
	  if (r<=R) res++;
  }
  out.print(res); 
  in.close(); out.close();  
}
}



