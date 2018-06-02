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
  //      br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(System.out);
    //	out = new PrintWriter(new File("output.txt"));
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
	char[] s = br.readLine().toCharArray();
	int n = s.length;
	char[] q = new char[n];
	int k = 0;
	for (char c:s) 
		if (k==0) q[k++] = c; else
			if (c!=q[k-1]) q[k++] = c; else k--;
	for (int i=0; i<k; i++) out.print(q[i]);
	
}      
} 
