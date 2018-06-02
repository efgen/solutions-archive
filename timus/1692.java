import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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
	int k = 1;
	
	while ((k+1)*(k+2)<=2*n) k++;
	int[][] a = new int[k+1][k];
	int s = 0;
	for (int i=0; i<k; i++) 
		for (int j=i; j<k; j++)
			a[i][j] = a[j+1][i] = ++s;
	out.println(k+1);
	for (int i=0; i<=k; i++) {
		out.print(k);
		for (int j=0; j<k; j++)
			out.print(" "+a[i][j]);
		out.println();
	}
	
}
} 











