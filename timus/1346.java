import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int b1 = nextInt();
  int n = nextInt()-b1+1;
  int[] a = new int[n];
  int k = 1;
  a[0] = nextInt();
  for (int i=1; i<n; i++) {
	  int x = nextInt();
	  if (x!=a[k-1]) a[k++] = x;
  }
  n = k;
  int res = 0;
  int p = 0;
  while (p<n) {
	  res++; p++;
	  if (p==n) break;
	  if (a[p]>a[p-1])	 
		  while (p<n && a[p]>a[p-1]) p++;
	  else
		  while (p<n && a[p]<a[p-1]) p++;	
  }
  out.println(res);

  out.close();    
}   

}


