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
  int px = in.nextInt();
  int py = in.nextInt();
  int h = in.nextInt();
  int x = in.nextInt();
  int y = in.nextInt(); 
  int might = in.nextInt();
  int d = 0;
  int s = 0;
  int[] a = new int[h+1]; 
  int[] b = new int[h+1];
  a[h] = x; 
  b[h] = y;
  if (x==y) s = h;
  for (int k=h-1; k>=0; k--) {
	  a[k] = a[k+1]/2 + a[k+1]%2;
	  b[k] = b[k+1]/2 + b[k+1]%2;	
	  if (a[k]==b[k]) s = Math.max(s, k);
  }
  px = h - px; py = h - py;
  if (px>s) { d += px-s; px = s; }
  if (py>s) { d += py-s; py = s; }
  d += Math.abs(px-py);
  if (d<=might) out.print("YES"); else out.print("NO");  
  in.close(); out.close();
}

}