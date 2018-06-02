import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int MN=2000000000;
  int[][] a = new int[31][31];
  for (int i=1; i<=30; i++)
	  for (int j=1; j<=30; j++)
		  a[i][j]=MN;
  int n = in.nextInt();
  a[0][0] = 1; a[0][1] = 0;
  for (int L=1; L<=n; L++){
	  a[L][0] = in.nextInt();
	  for (int p=1; p<=a[L][0]; p++) {
		  while (true) {
			  int x = in.nextInt(); if (x==0) break;
			  int v = in.nextInt();
			  if (a[L][p]>a[L-1][x]+v) a[L][p] = a[L-1][x]+v;
		  }		  
	  } 
	  if (L < n) {in.nextLine();in.nextLine();}
  }
  int min = MN;
  for (int i=1; i<=a[n][0]; i++)
	  if (a[n][i]<min) min = a[n][i];
  out.print(min);
  in.close();  out.close();
}

}