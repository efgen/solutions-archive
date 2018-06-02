import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;   
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
  
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

public void run() throws IOException {   
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt();
  long x = nextInt();
  long y = nextInt();
  long res = 0;
  long x0 = x, y0 = y;
  for (int i=1; i<n; i++) {	  
	  long px = x, py = y;
	  x = nextInt();
	  y = nextInt();
	  res += px*y-py*x;
  }
  res += x*y0-x0*y;
  if (res>0) out.print("c");
  out.print("cw"); 
  out.close();    
}   
  
}   