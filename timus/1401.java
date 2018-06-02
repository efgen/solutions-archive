import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}

int[][] a;
int k = 0;
void solv(int cx, int cy, int x, int y, int n) {
	if (n==0) return;
	n--;
	int m = 1<<n;
	/*k++;
	a[cx+m][cy+m] = k;
	a[cx+m-1][cy+m] = k;
	a[cx+m][cy+m-1] = k;
	a[cx+m-1][cy+m-1] = k;	*/
	if (x<m) {
		if (y<m) {
			k++;
			a[cx+m][cy+m] = k;
			a[cx+m-1][cy+m] = k;
			a[cx+m][cy+m-1] = k;
		//	a[cx+m-1][cy+m-1] = k;	
			solv(cx,cy,x,y,n);			
			solv(cx,cy+m,m-1,0,n);		
		} else {
			k++;
			a[cx+m][cy+m] = k;
		//	a[cx+m-1][cy+m] = k;
			a[cx+m][cy+m-1] = k;
			a[cx+m-1][cy+m-1] = k;	
			solv(cx,cy,m-1,m-1,n);
			solv(cx,cy+m,x,y-m,n);			
		}
		solv(cx+m,cy,0,m-1,n);
		solv(cx+m,cy+m,0,0,n);
	} else {		
		if (y<m) {
			k++;
			a[cx+m][cy+m] = k;
			a[cx+m-1][cy+m] = k;
	//		a[cx+m][cy+m-1] = k;
			a[cx+m-1][cy+m-1] = k;	
			solv(cx+m,cy,x-m,y,n);
			solv(cx+m,cy+m,0,0,n);
		} else {
			k++;
		//	a[cx+m][cy+m] = k;
			a[cx+m-1][cy+m] = k;
			a[cx+m][cy+m-1] = k;
			a[cx+m-1][cy+m-1] = k;	
			solv(cx+m,cy,0,m-1,n);
			solv(cx+m,cy+m,x-m,y-m,n);			
		}
		solv(cx,cy,m-1,m-1,n);
		solv(cx,cy+m,m-1,0,n);
	}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  int x = in.nextInt()-1;
  int y = in.nextInt()-1;
  a = new int[1<<n][1<<n];
  solv(0,0,x,y,n);
  for (int i=0; i<(1<<n); i++) {
	  for (int j=0; j<(1<<n); j++)
		  out.print(a[i][j]+" ");
	  out.println();
  } 
  in.close(); out.close();
}

}

