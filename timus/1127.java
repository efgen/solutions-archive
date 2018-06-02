import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
BufferedReader in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
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
  in = new BufferedReader(new InputStreamReader(System.in)); 
  out = new PrintWriter(System.out);
  HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();  
  for (int i=0; i<24;i++)
	  for (int j=0; j<6; j++)
		  p[i][j]--;
  int n = Integer.parseInt(in.readLine());
  for (int i=1; i<=n; i++) {
	  String s = in.readLine();
	  int[] a = new int[6];
	  a[0] = s.charAt(0)-'A';
	  a[4] = s.charAt(1)-'A';
	  a[2] = s.charAt(2)-'A';
	  a[1] = s.charAt(3)-'A';
	  a[3] = s.charAt(4)-'A';
	  a[5] = s.charAt(5)-'A';
	  
	  for (int k=0; k<24; k++) {
		  int[] r = perm(a,k);
		  int cod  = 0;
		  for (int j=2; j<6; j++) cod = 26*cod+r[j];
		  Integer x = map.get(cod);
		  if (x==null) x = 1; else x++;
		  map.put(cod, x);		 
	  }
	  
  }
  int res = 0;
  for (int cod:map.keySet()) 
	  res = Math.max(res, map.get(cod));
  out.print(res);
  
  out.close();
}

}


