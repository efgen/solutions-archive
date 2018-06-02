import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br); 
  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  int n = nextInt();
  int[] data = new int[n];
  for (int i=0; i<n; i++) data[i] = nextInt();
  Vector<Integer>[] l = new Vector[n];
  Vector<Integer>[] r = new Vector[n]; 
  /*for (int i=0; i<n; i++) {
	  l[i] = new Vector<Integer>();
	  r[i] = new Vector<Integer>();
  }*/
  
  int m = nextInt();
  int[] val = new int[m];
  int[] count = new int[m];
  int[] res = new int[m];
  for (int i=0; i<m; i++) {
	  int x = nextInt()-1;
	  int y = nextInt()-1;
	  if (l[x]==null) l[x] = new Vector<Integer>();
	  if (r[y]==null) r[y] = new Vector<Integer>();
	  l[x].add(i);
	  r[y].add(i);
	  val[i] = nextInt();	  
  }
  
  HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
  for (int i=0; i<n; i++) {
	  if (l[i]!=null)
	  for (int x:l[i]) {		  
		  Integer X = map.get(val[x]);
		  if (X==null) X = 0;		  
		  count[x] = X;
	  }
	  
	  if (map.containsKey(data[i])) map.put(data[i], map.get(data[i])+1); else map.put(data[i], 1);
	  if (r[i]!=null)
	  for (int x:r[i]) {
		  Integer X = map.get(val[x]);
		  if (X==null) X = 0;
		  if (X!=count[x]) res[x] = 1;
	  }
  }
  for (int x:res) out.print(x);
  out.close();    
}   

}
