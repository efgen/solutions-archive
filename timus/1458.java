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
      //  br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        //out= new PrintWriter(new File("output.txt"));
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
	int n = Integer.parseInt(br.readLine());
	boolean[][] a = new boolean[n][n];
	for (int i=0; i<n; i++) {
		String s = br.readLine();
		for (int j=0; j<n; j++)
			a[i][j] = s.charAt(j)=='W';
	}
	boolean[] x = new boolean[n];
	boolean[] y = new boolean[n];
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			if (a[i][j]) {
				x[i] = !x[i];
				y[j] = !y[j];
			}
	int k = 0;
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			if (a[i][j] ^ (x[i]^y[j])){
				k++;
			}
	int r = Math.min(k, n*n-k);
	out.println(r);
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			if ((k!=r) ^ (a[i][j] ^ (x[i]^y[j]))){
				out.println((i+1)+" "+(j+1));
			}
	
	
		
	
}
} 











