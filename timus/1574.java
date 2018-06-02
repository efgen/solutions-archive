import java.awt.Point;
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
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int min = 100000000, k = 0, x = 0;
  for (char c:br.readLine().toCharArray()) {
	  if (c=='(') x++; else x--;
	  if (x<min) {
		  min = x; k = 1;
	  } else
	  if (x==min) k++;
  }
  if (x!=0) k = 0;
  out.print(k);
  out.close();    
}   
  
}




