import java.io.*;         
import java.util.*;         
import java.math.*;         
 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000+10;
 
int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}
long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
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
//	new Main().run();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}

int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
int f(int x, int y) {
	return (x-1)*8+y-1;
}
public void solve() throws IOException {
	int n = 8;
	double[][] board = new double[n+2][n+2];
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j++)
			board[i][j] = nextD();
	int sz = n*n;
	double[][] a = new double[sz][sz];
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j++) {
			double s = 0;
			for (int k=0; k<dx.length; k++) {
				int nx = i+dx[k];
				int ny = j+dy[k];
				if (nx>0 && ny>0 && nx<9 && ny<9) {
					s += board[nx][ny];
				}
			}
			
			for (int k=0; k<dx.length; k++) {
				int nx = i+dx[k];
				int ny = j+dy[k];
				if (nx>0 && ny>0 && nx<9 && ny<9) {
					a[f(i,j)][f(nx, ny)] = board[nx][ny]/s;
				}
			}
		}
	n = 64;
	double[][] b = new double[n][n];	
	for (int p=0; p<50; p++) {		
			for (int i=0; i<n; i++)
				for (int j=0; j<n; j++) {
					double x = 0;
					for (int k=0; k<n; k++)
						x += a[i][k]*a[k][j];
					b[i][j] = x;
				}
		for (int i=0; i<n; i++) {
			double s = 0;
			for (int j=0; j<n; j++) s += b[i][j];
			for (int j=0; j<n; j++) a[i][j] = b[i][j] / s;
			Arrays.fill(b[i], 0);
		}
	}	
	n = 8;
	for (int i=0; i<n; i++){
		for (int j=0; j<n; j++)
			out.printf(Locale.US, "%.12f ",a[0][i*8+j]);
		out.println();
	}
	
	
	
}
  
}
 
 
  