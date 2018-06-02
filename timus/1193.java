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
  int n =in.nextInt();
  int[] t1 = new int[n+1], t2 = new int[n+1], t3  = new int[n+1];
  for (int i=1; i<=n; i++) {
	  t1[i] = in.nextInt();
	  t2[i] = in.nextInt();
	  t3[i] = in.nextInt();
  }
  for (int i=1; i<=n; i++) {
	  int min = i;
	  for (int j=i+1; j<=n; j++) 
		  if (t1[j]<t1[min]) min = j;
	  int q = t1[i]; t1[i] = t1[min]; t1[min] = q;
	  q = t2[i]; t2[i] = t2[min]; t2[min] = q;
	  q = t3[i]; t3[i] = t3[min]; t3[min] = q;
  }
  int res = 0, t = 0;
  for (int i=1; i<=n; i++) {
	  if (t<t1[i]) t = t1[i];
	  t += t2[i];
	  res = Math.max(res, t-t3[i]);
  }
  out.print(res);
  in.close();  out.close();
}

}