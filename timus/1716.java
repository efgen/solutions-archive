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
    	//br = new BufferedReader(new FileReader(new File(filename+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}


double f(int n, int s) {
	int k = s-2*n;
	if (k==n) return n;
	if (k==0) return n-1;
	if (k==1) {
		if (n==2) return 0.5;
		if (n==3) return 1;
		return (n-1 + n-2 + (n-2)*(n-3))*1.0/n;
	}
	if (k+1==n) {
		if (n==3) return 4.0/3;
		return (n-1 + (n-1)*(n-2))*1.0/n; 
	}
	return (k*(k-1)+(n-k)*(n-k-1)+k)*1.0/n;
}

public void solve() throws IOException {
	int n = nextInt();
	int s = nextInt();
	out.printf(Locale.US,"%1.6f",n- f(n, s));	
}
}





