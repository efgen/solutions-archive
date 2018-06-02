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
  out.print(n-1);
  out.print(" ");
  if (n%2==0) out.print(3*((n-2)/2)+1); else out.print(3*((n - 1)/2));
  out.close();    
}   
  
}