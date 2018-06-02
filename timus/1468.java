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
  while (true) {
	  int p = in.nextInt();
	  int q = in.nextInt();
	  if (q==0) break;
	  int d = in.nextInt();
	  out.print(Integer.toString(p/q,d).toUpperCase());
	  p %= q;
	  if (p>0) { 
		  out.print("."); 
		  StringBuffer sb = new StringBuffer("");
		  int[] a = new int[q]; Arrays.fill(a, -1);
		  int k = 0;
		  while (p>0) {
			  if (a[p]<0) a[p] = k; else break; k++;
			  p *= d;			
			  sb.append(Integer.toString(p/q,d));
			  p %= q; 			
		  }
		  String s = sb.toString().toUpperCase();
		  if (p==0) out.print(s); else {			 
			  out.print(s.substring(0,a[p]));
			  out.print("(");
			  out.print(s.substring(a[p], s.length()));
			  out.print(")");
		  }
	  }	  
	  out.println();
  }
  in.close(); out.close();
}

}
