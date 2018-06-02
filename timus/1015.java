import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
int[] nextD() throws IOException{
	int[] a = new int[6];
	a[2] = nextInt();
	a[4] = nextInt();
	a[3] = nextInt();
	a[0] = nextInt();
	a[5] = nextInt();
	a[1] = nextInt();
	return a;
}
int[][] p = {
		{1,2,3,4,5,6},
		{1,2,4,5,6,3},
		{1,2,5,6,3,4},
		{1,2,6,3,4,5},
		{2,1,5,4,3,6},
		{2,1,4,3,6,5},
		{2,1,3,6,5,4},
		{2,1,6,5,4,3},
		{3,5,2,4,1,6},
		{3,5,4,1,6,2},
		{3,5,1,6,2,4},
		{3,5,6,2,4,1},
		{4,6,2,5,1,3},
		{4,6,5,1,3,2},
		{4,6,1,3,2,5},
		{4,6,3,2,5,1},
		{5,3,2,6,1,4},
		{5,3,6,1,4,2},
		{5,3,1,4,2,6},
		{5,3,4,2,6,1},
		{6,4,2,3,1,5},
		{6,4,3,1,5,2},
		{6,4,1,5,2,3},
		{6,4,5,2,3,1},
};
int[] perm(int[]a,int i) {
	int[] r = new int[6];
	for (int k=0; k<6; k++)
		r[k] = a[p[i][k]];
	return r;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
  Vector<Integer>[] res = new Vector[40];
  for (int i=0; i<res.length; i++) res[i] = new Vector<Integer>();
  int kk = 0;
  for (int i=0; i<24;i++)
	  for (int j=0; j<6; j++)
		  p[i][j]--;
  int n = nextInt();
  for (int i=1; i<=n; i++) {
	  int[] a = nextD();
	  for (int k=0; k<24; k++) {
		  int[] r = perm(a,k);
		  if (r[0]==1 &&((r[1]==2 && r[2]==3)||r[2]==2)) {	
			  int cod = 0;
			  for (int x:r) cod = 10*cod+x;
			  Integer x = map.get(cod);
			  if (x==null) { x = ++kk; map.put(cod, x); }			
			  res[x].add(i);
			  break;
		  }
	  }
	  
  }
  
  out.println(kk);
  for (int i=1; i<=kk; i++) {
	  for (int x:res[i]) out.print(x+" ");
	  out.println();
  }
  out.close();
}

}


