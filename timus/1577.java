import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
int MOD = inf+7;
public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  	char[] a = in.next().toCharArray();
	char[] b = in.next().toCharArray();
	int n = a.length, m = b.length;  
	int[][] dp = new int[n+1][m+1];
	int[][] nop = new int[n+1][m+1];
	for (int i=0; i<=n; i++) {
		dp[i][0] = 1;
		nop[i][0] = i;
	}
	for (int i=0; i<=m; i++) {
		dp[0][i] = 1;
		nop[0][i] = i;
	}
	
	for (int i=1; i<=n; i++)
		for (int j=1; j<=m; j++)
			if (a[i-1]==b[j-1]) {
				nop[i][j] = nop[i-1][j-1]+1;
				dp[i][j] += dp[i-1][j-1]; 
			} else {
				if (nop[i-1][j]<=nop[i][j-1]) {
					nop[i][j] = nop[i-1][j]+1;
					dp[i][j] += dp[i-1][j];  
				} 
				if (nop[i-1][j]>=nop[i][j-1]){
					nop[i][j] = nop[i][j-1]+1;
					dp[i][j] += dp[i][j-1];
					if (dp[i][j]>=MOD) dp[i][j] -= MOD; 
				}
			}
	out.print(dp[n][m]);			
  
  in.close(); out.close();  
}
}



