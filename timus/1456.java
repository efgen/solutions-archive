import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int n;
int fi(int x) {
	int res = 1;
	int p = 2;
	while (x>1) {
		if (x%p==0) {
			int m = 1;
			while (x%p==0) {
				x /= p;
				m *= p;
			}
			res *= m-m/p;
		}
		if (p*p>x) p = x; else p++;
	}
	return res;
}
int pow(int x,int p) {
	long a = 1;
	long b = x;
	while (p>0) {
		if (p%2==1) a = (a*b)%n;
		p /= 2;
		b = (b*b)%n;
	}
	return (int)a;
}
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b,a%b);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int a = in.nextInt();
  n = in.nextInt();
  if (gcd(a,n)==1) {
	  int x = fi(n);
	  int res = x;
	  for (int d=1; d*d<=x; d++) 
		  if (x%d==0) {
			  if (d<res && pow(a,d)==1) res = d;
			  if (x/d<res && pow(a,x/d)==1) res = x/d;
		  }
	  out.print(res);
  } else out.print(0);
  in.close(); out.close();
}

}

