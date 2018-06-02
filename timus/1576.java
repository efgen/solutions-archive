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
  int n1 = in.nextInt();
  int c1 = in.nextInt();
  int n2 = in.nextInt();
  int T = in.nextInt();
  int c2 = in.nextInt();
  int n3 = in.nextInt();
  int K = in.nextInt();
  int time = 0;
  while (K-->0) {
	  String[] ss = in.next().split(":");
	  int m = Integer.parseInt(ss[0]);
	  if (ss[1].charAt(0)=='0') ss[1] = ss[1].substring(1);
	  int s = Integer.parseInt(ss[1]);
	  int t = 60*m+s;
	  if (t>6) {
		  time += m;
		  if (s>0) time++;
	  }
  }
  int r1 = n1+c1*time;
  int r2 = n2;
  if (time>T) {
	  r2 += (time-T)*c2;
  }
  int r3 = n3;
  out.println("Basic:     "+r1);
  out.println("Combined:  "+r2);
  out.println("Unlimited: "+r3);
  in.close(); out.close();  
}
}



