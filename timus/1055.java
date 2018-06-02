import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
int[] prime = new int[5200];
int[] res = new int[5200];
int k = 0;

public static void main(String[] args) throws IOException {
new Main().run();
}

void solv1(int n) {
	for (int i=1; i<=k; i++) {
		int p = prime[i];
		int x = n;
		while (x>0) {
			x /= p;
			res[i] += x;
		}
	}
}
void solv2(int n) {
	for (int i=1; i<=k; i++) {
		int p = prime[i];
		int x = n;
		while (x>0) {
			x /= p;
			res[i] -= x;
		}
	}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US); 
  out = new PrintWriter(System.out);  
  k = 2; prime[1] = 2; prime[2] = 3;
  for (int n=5; n<50000; n+=2) {
	  boolean f = true;
	  for (int i=1; i<=k && prime[i]*prime[i]<=n; i++)
		  if (n%prime[i]==0) {f = false; break;}
	  if (f) prime[++k] = n;
  }
  int n = in.nextInt();
  int m = in.nextInt();
  solv1(n); solv2(m); solv2(n-m);
  int d = 0;
  for (int i=1; i<=k; i++)
	  if (res[i]>0) d++;
  out.print(d);
  in.close();  out.close();
}

}


