import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

//Scanner in;
StreamTokenizer st;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}


int nextInt() throws IOException
{
   st.nextToken();
   return (int)st.nval;
}

public void run() throws IOException {
//  in = new Scanner(System.in); in.useLocale(Locale.US);   
  st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  out = new PrintWriter(System.out);
  int n = nextInt();
  int[] s = new int[n+2];
  for (int i=0; i<=n; i++) {
	  int a = nextInt();
	  int b = nextInt();
	  int c = nextInt();
	  s[a] += c;
	  s[b+1] -= c;	  
  }

  int r = 0;
  for (int i=1; i<=n; i++) {
	  r += s[i];
	  out.print(r+" ");
  }
	  

//  in.close(); 
  out.close();
}

}


