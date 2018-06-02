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
//  int d = (int)Math.round(Math.sqrt(n+2))*3;
  int d = 1000000;
  int res = n-1;  
  for (int k=3; k*k<=n; k++)
	  if (n%k==0) {
		  res = k-1;	
		  break;
	  }
  if (n%2==0) {
	  int k = n/2-1;
	  if (k>1) res = Math.min(res, k);
  }
  out.print(res); 
  
  in.close(); out.close();
}

}
