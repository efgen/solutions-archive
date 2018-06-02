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
double nextInt() throws IOException {
	in.nextToken();
	return in.nval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = Integer.parseInt(br.readLine());
  int[] ost = {3241,3214,3124,2341,2314,2413,2134};
  while (n-->0) {
	  int[] a = new int[10];
	  String s = br.readLine();
	  for (char c:s.toCharArray()) a[c-'0']++;
	  a[1]--; a[2]--; a[3]--; a[4]--;
	  int x = 0;
	  for (int i=9; i>0; i--) 
		  while (a[i]>0) {
			  a[i]--;
			  out.print(i);
			  x = (10*x+i)%7;
		  }
	  x = 10000*x%7;
	  x = (7-x)%7;
	  out.print(ost[x]);
	  while (a[0]-->0) out.print(0);
	  out.println();
  }
  out.close();    
}   
  
}