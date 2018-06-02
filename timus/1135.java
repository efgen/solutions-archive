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
  //in = new StreamTokenizer(br); 
  out = new PrintWriter(System.out);  
  int n = Integer.parseInt(br.readLine());
  int res = 0, r = 0;
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;
	  for (char c:s.toCharArray())
		  if (c=='>') r++; else res += r;
  }
  out.print(res);
  out.close();    
}   
  
} 