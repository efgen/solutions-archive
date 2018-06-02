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

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  TreeSet<Integer> free = new TreeSet<Integer>();
  int maxn = 66000;
  int dt = 600;
  TreeSet<Integer>[] Q = new TreeSet[maxn];
  for (int i=0; i<maxn; i++) Q[i]  = new TreeSet<Integer>();
  int[] td = new int[maxn];
  for (int i=1; i<=30000; i++) free.add(i);
  int lastt =0;
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;
	  String[] ss = s.split(" ");
	  int time = Integer.parseInt(ss[0]);
	  for (int tt=lastt+1; tt<=time; tt++) {		 
		  for (int x:Q[tt])
			  free.add(x);	  		
	  }
	  lastt = time;
	  if (ss[1].charAt(0)=='+') {
		  int x = free.first();		  
		  free.remove(x);
		  Q[time+dt].add(x);
		  td[x] = time+dt;
		  out.println(x);		  
	  } else {
		  int x = Integer.parseInt(ss[2]);
		  if (td[x]<=time)  out.println("-"); else {
			  out.println("+");
			  Q[td[x]].remove(x);
			  Q[time+dt].add(x);
			  td[x] = time+dt;
		  }
	  }
  }
  out.close();    
}   

}




