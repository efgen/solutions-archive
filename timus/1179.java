import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int comp(int b) {
	if (b<=10) return '0'+b-1; else return 'A'+b-11;
}
public void run() throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in)); 
  out = new PrintWriter(System.out);
  int[] a = new int[37];
  while (true) {
	  String s = in.readLine();
	  if (s==null) break;
	  int len = s.length();
	  boolean[] f = new boolean[100]; f['0'] = true; 	
	  for (int b=2; b<=36; b++) {
		  f[comp(b)] = true;
		  boolean w = false;
		  for (int i=0; i<len; i++) 
			  if (f[s.charAt(i)]) {
				  if (!w) {
					  w = true;
					  a[b]++;
				  } 
			  } else w = false;		  
	  }
  }
  int best = 2;
  for (int i=3; i<=36; i++) 
	  if (a[i]>a[best]) best = i;
  out.print(best+" "+a[best]);
  out.close();
}

}

