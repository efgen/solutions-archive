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
 //       br = new BufferedReader(new FileReader("input.txt"));      
 //      out= new PrintWriter(new File("output.txt"));
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
	int n = nextInt();
	int k = nextInt();
	int m = nextInt();
	for (int i=1; i<=n; i++) out.println((i-1)%k+1);
	boolean[][] a = new boolean[n+1][n+1];
	for (int i=1; i<=n; i++)
		for (int j=i+1; j<=n; j++) 
		if ((i%k)!=(j%k)){
			a[i][j] = true;
		}
	for (int i=1; i<n; i+=2) {
		out.println(i+" "+(i+1));
		a[i][i+1] = false;
	}
	m -= n/2;
	if (n%2==1) {
		for (int i=1; i<n; i++)
			if (a[i][n]) {
				a[i][n] = false;
				out.println(i+" "+n);
				m--;
				break;
			}
	}
	for (int i=1; m>0 && i<=n; i++)
		for (int j=i+1; m>0 && j<=n; j++) 
			if (a[i][j]) {
				out.println(i+" "+j);
				m--;
			}

	
	
}      
} 



















