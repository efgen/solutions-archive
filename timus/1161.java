import java.io.*;
import java.util.*;
import java.math.*;



public class Main {
Scanner in;
PrintWriter out;
double[] a;

public static void main(String[] args) throws IOException {
new Main().run();
}

void sift(int i, int n){
	int k = 2*i;
	while (k<=n) {
		if (k<n && a[k+1]>a[k]) k++;
		if (a[i]>a[k]) return;
		double t = a[i]; a[i] = a[k]; a[k] = t; 
		i = k; k *= 2;
	}
}

public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  a = new double[n+2];
  for (int i=1; i<=n; i++) a[i] = in.nextDouble();
  for (int i=n/2; i>0; i--) sift(i,n);
  while (n>1){
	  double m = a[1]; 
	  a[1] = a[n]; n--; sift(1,n);
	  a[1] = 2*Math.sqrt(m*a[1]);
	  sift(1,n);	  
  }
  out.printf(Locale.CHINA, "%1.2f", a[1]);
  in.close();  out.close();
}

}