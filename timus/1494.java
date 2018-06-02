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
	return (int) in.nval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out);  
  int n = nextInt();
  int k = 0;
  Stack<Integer> st = new Stack<Integer>();
  boolean f = true;
  for (int i=1; i<=n; i++) {
	  int x = nextInt();
	  while (k<x) st.push(++k);
	  if (st.peek()==x) st.pop(); else {
		  f = false;
		  break;
	  }	  
  }
  f  &= st.isEmpty();
  if (f) out.print("Not a proof"); else out.print("Cheater");
  out.close();    
}   
  
}