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
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

int maxx,maxy,minx,miny;
void relax(int x, int y) {
	if (x<minx) minx = x; else
		if (x>maxx) maxx = x;
	if (y<miny) miny = y; else
		if (y>maxy) maxy = y;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int kk = 0;
  while (true) {
	  in.nextToken();
	  if (in.ttype!=in.TT_NUMBER) break; else  kk++;
	  int x1 = 2*(int)in.nval;
	  int y1 = 2*nextInt();
	  int x2 = 2*nextInt();
	  int y2 = 2*nextInt();
	  int a = y2-y1;
	  int b = x1-x2;
	  int x = x2-x1;
	  int y = y2-y1;
	  int xc = (x1+x2)>>1;
	  int yc = (y1+y2)>>1;
	  if (x*b<y*a) {
		  a = -a;
		  b = -b;
	  }
	  if (kk==1) {
		  minx = maxx = x1;
		  miny = maxy = y1;
	  }
	  relax(x1,y1);
	  relax(x2,y2);
	  relax(xc+a/2,yc+b/2);	  
	  
  }
  double w = (maxx-minx)/2.0;
  double h = (maxy-miny)/2.0;
  if (kk==0) {w = 0; h = 0;}
  out.printf(Locale.US, "%1.4f %1.4f",w,h);
  out.close();    
}   

}




