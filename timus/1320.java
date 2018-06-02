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
Vector<Integer>[] a = new Vector[1001];
boolean[] f = new boolean[1001];
int res = 0;
void dfs(int v) {
	f[v] = true;
	res += a[v].size();
	for (int x:a[v])
		if (!f[x]) dfs(x);
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  for (int i=1; i<=1000; i++) a[i] = new Vector<Integer>();
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;
	  String[] ss = s.split(" ");
	  int x = Integer.parseInt(ss[0]);
	  int y = Integer.parseInt(ss[1]);
	  a[x].add(y);
	  a[y].add(x);
  }
  boolean ok = true;
  for (int i=1; i<=1000; i++)
	  if (!f[i]) {
		  res = 0;
		  dfs(i);		
		  res/=2;
		  if (res%2==1) ok = false;
	  }
  if (ok) out.print(1); else out.print(0);
  out.close();    
}   
  
}




