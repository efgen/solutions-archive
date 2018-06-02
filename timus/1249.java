import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
StreamTokenizer in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}
boolean nextB()throws IOException {
	in.nextToken();
	return in.nval>0;
}
void pizdec() {
	out.print("No");
	out.close();
	System.exit(0);
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int m = nextInt();
  boolean[] a = new boolean[m];
  boolean[] b = new boolean[m];
  for (int i=0; i<m; i++) a[i] = nextB();
  for (int j=1; j<n; j++) {
	  for (int i=0; i<m; i++) b[i] = nextB();
	  int k = 0;
	  while (k<m) {
		  while (k<m && !a[k]) k++;
		  if (k<m && a[k]) {
			  if (k>0 && b[k] && b[k-1]) pizdec();
			  boolean f = b[k];
			  while (k<m && a[k])
				  if (b[k]!=f) pizdec(); else k++;
			  if (k<m && b[k] && b[k-1]) pizdec();
		  }
	  }
	  for (int i=0; i<m; i++) a[i] = b[i];
  }
  out.print("Yes"); 
  out.close(); 
}

}

