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
  int n = nextInt();
  int max = 0, s = 0;
  for (int i=0; i<n; i++) {
	  int x = nextInt();
	  if (x>max) max = x;
	  s += x;
  }
  s = max-(s-max);
  if (s<=0) s = 1;
  out.print(s+" "+max);
  out.close();    
}   

}
