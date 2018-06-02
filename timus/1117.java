import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
long[] a = new long[40];

public static void main(String[] args) throws IOException {
new Main().run();
}

long f(int x) {
	long res = 0;
	boolean fl = false;
	int k = 0;
	while (x>0) {
		if (x%2==1) {
			res += a[k];
			if (fl) res += k-1; else fl = true;
		}
		x /= 2; k++;
	}
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);   
  a[0] = 0;  
  for (int i = 1; i<=32; i++)
	  a[i] = 2*a[i-1]+i-1;
  int x = in.nextInt();
  int y = in.nextInt();
  out.print(Math.abs(f(x)-f(y)));
  in.close(); out.close();
}

}
