import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {  
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  int n = in.nextInt(), k = in.nextInt(), p = 1;
  if (k>n) {out.print(0); in.close();  out.close(); return;}
  int[] a = new int[n+1]; 
  while (p<=n) {
	  String s = in.nextLine();
	  for (int i=0; i<s.length() && p<=n; i++)
		  if (s.charAt(i)=='*') a[p++]=-1; else a[p++] = s.charAt(i)-'0';
  }
  int best = 1000000000, s = 0, inf = 0, res = 0;
  for (int i=1;i<=k; i++) 
	  if (a[i]<0) inf++; else s += a[i];
  if (inf==0 && s<best) {best = s; res = 1;}
  for (int i=k+1; i<=n; i++) {
	  if (a[i]<0) inf++; else s += a[i];
	  if (a[i-k]<0) inf--; else s -= a[i-k];
	  if (inf==0 && s<best) {best = s; res = i-k+1;}
  }
  out.print(res);
  out.close();
}

}

