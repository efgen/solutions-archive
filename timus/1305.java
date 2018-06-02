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
  int x = nextInt(), y = nextInt(), px = 0, py = 0;
  int minx = x, maxx = x, miny = y, maxy = y,minxy = x+y, maxxy = x+y, minyx = x-y, maxyx = x-y;
  for (int i=1; i<n; i++) {
	  x = nextInt();
	  y = nextInt();
	  if (x<minx) minx = x;
	  if (x>maxx) maxx = x;
	  if (y<miny) miny = y;
	  if (y>maxy) maxy = y;
	  if (x+y<minxy) minxy = x+y;
	  if (x+y>maxxy) maxxy = x+y;
	  if (x-y<minyx) minyx = x-y;
	  if (x-y>maxyx) maxyx = x-y;	  
  }
  x = minx; y = minxy-x;
  int x0 = x, y0 = y;
  out.println(x+" "+y); px = x; py = y;
  y = miny; x = minxy-y;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  x = maxyx+y;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  x = maxx; y =x-maxyx;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  y = maxxy-x;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  y = maxy; x = maxxy-y;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  x = minyx+y;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  x = minx; y = x-minyx;
  if ((x!=px || y!=py)&&(x!=x0 || y!=y0)) {out.println(x+" "+y); px = x; py = y;}
  out.close();    
}   
  
}   