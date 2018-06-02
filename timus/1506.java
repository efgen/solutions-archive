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
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int k = in.nextInt();
  int[] a = new int[n+1];
  for (int i=1; i<=n; i++) a[i] = in.nextInt();
  int h = (int)Math.ceil(n*1.0/k); 
  for (int i=1; i<=h; i++) {
	  for (int j=0; j<k; j++) {
		  int x = j*h+i;
		  if (x>n) continue;
		  out.printf("%4d",a[x]);
	  }
	  out.println();
  }
  in.close();  out.close();
}
}
