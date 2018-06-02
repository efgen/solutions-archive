import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}
int min(int a, int b) {
	if (a<b) return a; else return b;
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  int L1 = in.nextInt(), L2 = in.nextInt(), L3 = in.nextInt(), 
      C1 = in.nextInt(), C2 = in.nextInt(), C3 = in.nextInt();
  int n = in.nextInt();
  int s = in.nextInt()-1;
  int t = in.nextInt()-1;
  if (s>t) {int q = s; s = t; t = q;}
  int[] a = new int[n];
  for (int i=1; i<n; i++) a[i] = in.nextInt(); 
  int[] r = new int[n];
  for (int i=s+1; i<=t; i++) r[i] = 2000000000;
  for (int i=s+1; i<=t; i++)
	  for (int j=i-1; j>=s; j--) {
		  if (a[i]-a[j]<=L1) r[i] = min(r[i],r[j]+C1); else
			  if (a[i]-a[j]<=L2) r[i] = min(r[i],r[j]+C2); else
				  if (a[i]-a[j]<=L3) r[i] = min(r[i],r[j]+C3); else
					  break;		 
	  }
  out.print(r[t]);  
  in.close(); out.close();
}

}


