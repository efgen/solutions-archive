import java.io.*;
import java.util.*;
import java.math.*;



public class Main {
StreamTokenizer in;
PrintWriter out;
double[] a;

public static void main(String[] args) throws IOException {
new Main().run();
}
int nextInt() throws IOException{
	in.nextToken();
    return (int)in.nval;
}


public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int[] a = new int[n];
  for (int i=0; i<n; i++) a[i] = nextInt();
  int res = 0;
  int m = nextInt();
  while (m-->0) 
	  if(Arrays.binarySearch(a, nextInt())>=0) res++;
  out.print(res);
  out.close();
}

}