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
	double n = nextInt();
	double m = nextInt();
	out.println(n * m + (n + m + 1) * (Math.sqrt(2.0) - 1));	
}      
} 



















