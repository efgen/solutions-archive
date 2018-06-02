import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
int inf, max;
boolean[][] a = new boolean[4][4], b = new boolean[4][4];

public static void main(String[] args) throws IOException {
new Main().run();
}

int Zn() {
	int res = 0;
	for (int i=0; i<4; i++)
		for (int j=0; j<4; j++) {
			res *= 2;
			if (a[i][j]) res++;
		}
	return res;			
}
int bfs() {
	int[] d = new int[max+1], Q = new int[max+1]; 
	Arrays.fill(d, inf);
	int s = -1, t = 0; Q[0] = Zn(); d[Q[0]] = 0;
	while (s<t) {
		  int r = Q[++s];
		  if (r==0 || r==max) return d[r];
		  for (int i=3; i>=0; i--)
			  for (int j=3; j>=0; j--) {
				  b[i][j] = (r%2)==1;
				  r /= 2;
			  }
		  for (int i=0; i<4; i++)
			  for (int j=0; j<4; j++) { 
				  for (int x=0; x<4; x++) 
					  for (int y=0; y<4; y++) 
						  if (Math.abs(x-i)+Math.abs(y-j)<2) a[x][y] = !b[x][y]; else a[x][y] = b[x][y];
				  int x = Zn();
				  if (d[x]<inf) continue;
				  Q[++t] = x;
				  d[x] = d[Q[s]]+1;				
			  } 
	}
	return -1;	
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  inf = 1 << 20; max = (1 << 16) - 1;
  for (int i=0; i<4; i++) {
	  String str = in.nextLine();
	  for (int j=0; j<4; j++)
		  a[i][j] = str.charAt(j)=='b';
  }
  int res = bfs();
  if (res < 0) out.print("Impossible"); else out.print(res);           

  in.close();  out.close();
}

}


