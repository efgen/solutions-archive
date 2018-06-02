import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);  
	int n = in.nextInt();
	String s = in.next();		
	int[] a = new int[n+2];
	int[] id = new int[n+2];
	int[] cc = new int[8];
	for (int i=0; i<n; i++) {
		int c = 1;
		if (s.charAt(i)=='G') c = 2;
		if (s.charAt(i)=='B') c = 4;
		a[i+1] = c;
		id[i+1] = i+1;
		cc[c]++;
	}
	out.println(n-3);
	while (n>3) {
		a[0] = a[n];
		id[0] = id[n];
		a[n+1] = a[1];
		id[n+1] = id[1];
		int pos = 0;
		for (int i=1; pos==0; i++)
			if (cc[a[i]]>1 && a[i-1]+a[i]+a[i+1]==7) pos = i;
		cc[a[pos]]--;
		out.println(id[pos-1]+" "+id[pos+1]);
		for (int i=pos; i<n; i++) {
			a[i] = a[i+1];
			id[i] = id[i+1];
		}
		n--;			
	}
	

  in.close(); out.close();  
}
}
