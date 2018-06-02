import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
 
  out = new PrintWriter(System.out);
  int[] a = new int[1000];
  int n = nextInt();
  while (n-->0) a[nextInt()]++;
  int res =0;
  for(int x:a) res += x/4;
  out.print(res);
  out.close();    
}   

}
