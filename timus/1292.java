import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

int F(int n, int k) {
	n--;
	while (n-->0) {	
		int x = k; k =0;
		while (x>0) {
			k += (x%10)*(x%10)*(x%10);
			x /= 10;
		}
		if (k==153) return k;
	}
	return k;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int test = nextInt();
  while (test-->0) 		 
	  out.println(F(nextInt(),nextInt())-nextInt());  
  out.close();
}

}

