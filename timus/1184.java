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
  int n = in.nextInt();
  int k = in.nextInt();
  int[] a = new int[n];
  for (int i=0; i<n; i++) 
	  a[i] = (int)(in.nextDouble()*100);  
  int l = 1;
  int r = 1;
  for (int x:a) 
	  if (x>r) r = x;
  while (r-l>1) {
	  int q = (l+r)/2;
	  int kk = 0;
	  for (int x:a) kk += x/q;  
	  if (kk>=k) l = q; else r = q;	 
  }
  int q = r+1;
  while (q>0) {
	  int kk = 0;
	  for (int x:a) kk += x/q;  
	  if (kk>=k) break; else q--;	  
  } 
  out.printf("%d.%02d",q/100,q%100);  
  in.close(); out.close();
}

}
