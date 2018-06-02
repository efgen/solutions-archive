import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {   


StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {      
//        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
//        br = new BufferedReader(new FileReader("input.txt"));      
 //       out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);    	
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

public void solve() throws IOException {
	int maxs = 900, maxsk = 8100;
	byte[][] dp = new byte[maxs+1][maxsk+1]; 
	byte[][] a = new byte[maxs+1][maxsk+1]; 
	dp[0][0] = 10;
	for (byte[] aa:a) Arrays.fill(aa, (byte)127);
	a[0][0] = 0;
	for (int s=1; s<=maxs; ++s)
		for (int sk=1; sk<=maxsk; ++sk)
			for (byte c=1; c<10; ++c) {
				if (s-c>=0 && sk-c*c>=0 && dp[s-c][sk-c*c]>0 && a[s][sk]>1+a[s-c][sk-c*c]){
					dp[s][sk] = c;	
					a[s][sk] = (byte)(1+a[s-c][sk-c*c]);
				}				
			}
	int t = nextInt();
	int[] d = new int[11];
	while (t-->0) {
		int s = nextInt();
		int sk = nextInt();
		if (s>maxs || sk>maxsk || dp[s][sk]==0 || a[s][sk]>100) {
			out.println("No solution");			
		} else {
			Arrays.fill(d, 0);
			while (s>=0 && sk>=0) {
				int c = dp[s][sk];
				s -= c;
				sk -= c*c;
				d[c]++;
			}		
			for (int i=1; i<10; ++i)
				while (d[i]-->0) out.print(i);
			out.println();
		}
	}
}      
} 



















