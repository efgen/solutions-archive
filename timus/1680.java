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
	String[] sss = br.readLine().split(" ");
	int n = Integer.parseInt(sss[1]);
	int q = Integer.parseInt(sss[2]);
	HashSet<String> hs = new HashSet<String>();
	while (n-->0) {
		String s = br.readLine();
		if (s.charAt(s.length()-2)=='#') {
			String ss = s.substring(0,s.length()-3);
			if (hs.contains(ss)) continue;
			hs.add(ss);
			q--;
			if (q<0) {
				out.println(s);
				return;
			}
		} else
		{
			q--;
			if (q<0) {
				out.println(s);
				return;
			}
		}
		
	}

	
}
} 












