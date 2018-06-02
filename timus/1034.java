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

int[]a;
int n;
boolean test(int x, int y, int z) {	
	for (int i=1; i<=n; i++) {		
		if (i!=x && Math.abs(i-x)==Math.abs(a[i]-a[x])) return false;
		if (i!=y && Math.abs(i-y)==Math.abs(a[i]-a[y])) return false;
		if (i!=z && Math.abs(i-z)==Math.abs(a[i]-a[z])) return false;
	}
	return true;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  n = in.nextInt();
  a = new int[n+1];
  for (int i=1; i<=n; i++) {
	  int x = in.nextInt();
	  int y = in.nextInt();
	  a[x] = y;
  }   
  int res = 0, q = 0;
  for (int i=1; i<=n-2; i++)
	  for (int j=i+1; j<=n-1; j++)
		  for (int k=j+1; k<=n; k++) {			
			  q = a[i]; a[i] = a[j]; a[j] = a[k]; a[k] = q;
			  if (test(i,j,k)) res++;
			  q = a[i]; a[i] = a[j]; a[j] = a[k]; a[k] = q;
			  if (test(i,j,k)) res++;
			  q = a[i]; a[i] = a[j]; a[j] = a[k]; a[k] = q;
		  }
  out.println(res);
  in.close(); out.close();  
}
}


