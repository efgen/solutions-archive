import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}

public void run() throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in)); 
  out = new PrintWriter(System.out);  
  int sto = 10000;
  int n = Integer.parseInt(new StringTokenizer(in.readLine()).nextToken());
  boolean[] f = new boolean[n+1];
  int max[] = new int[n+1]; Arrays.fill(max, sto);
  int min[] = new int[n+1]; Arrays.fill(min, 1);
  for (int i=1; i<=n; i++) {
	  StringTokenizer st = new StringTokenizer(in.readLine()); st.nextToken();
	  int k = Integer.parseInt(st.nextToken());
	  if (k==1) {
		  f[i] = true;
		  int x = Integer.parseInt(st.nextToken());
		  min[i] = x;
		  max[i] = x;
	  }
  }
  for (int i=1; i<=n; i++)
	  if (f[i]) {
		  for (int j=1; j<i; j++)
			  if (!f[j]) min[j] = Math.max(min[j], min[i]);
		  for (int j=i+1; j<=n; j++)
			  if (!f[j]) max[j] = Math.min(max[j], max[i]);
	  }
  int maxx = 0;
  int minx = 0;
  for (int i=1; i<=n; i++) {
	  maxx += max[i];
	  minx += min[i];
  }
 // out.println(maxx);
 // out.println(minx);
  if ((minx<=sto) && (maxx>=sto)) out.println("YES"); else out.println("NO");
  out.close();
}

}

