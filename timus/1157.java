import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int solv(int x) {
	int res = 0;
	for (int p=1; p*p<=x; p++)
		if (x%p==0) res++;
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int m = in.nextInt();
  int n = in.nextInt();
  int k = in.nextInt();
  int res = 0;
  for (int l=k+1; l<=10000; l++) 
	  if ((solv(l)==n) && (solv(l-k)==m)) {
		  res = l;
		  break;
	  }  
  out.print(res);
  in.close(); out.close();
}

}
