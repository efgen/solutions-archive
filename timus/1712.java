import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
long inf = 1000000000000000000l;   


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
}      
public void run()  {      
    try {          
//    	br = new BufferedReader(new FileReader(new File(filename+".in")));
//   	out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
//    	br = new BufferedReader(new FileReader(new File("input.txt")));
//    	out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

public void solve() throws IOException {
	int n = 4;
	boolean[][] a = new boolean[n][n];
	for (int i=0; i<n; i++) {
		char[] s = br.readLine().toCharArray();
		for (int j=0; j<n; j++)
			a[i][j] = s[j]=='X';
	}
	char[][] c = new char[n][n];
	for (int i=0; i<n; i++)
		c[i] = br.readLine().toCharArray();
	for (int k=0; k<n; k++) {
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (a[i][j]) out.print(c[i][j]);
		boolean[][] b = new boolean[n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				b[i][j] = a[n-1-j][i];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				a[i][j] = b[i][j];
		
	}
	                               

}
}





