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

public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	String[][] s = new String[n][];
	for (int i=0; i<n; i++) {
		s[i] = br.readLine().split(" ");
		Arrays.sort(s[i]);
	}
	String[] res = new String[n];
	int p = 0;
	boolean ok = true;
	for (String ss:br.readLine().split(" ")) {
		int x = Integer.parseInt(ss)-1;
		if (p==0) res[p] = s[x][0]; else {
			for (int i=0; i<3; i++)
				if (s[x][i].compareTo(res[p-1])>0) {
					res[p] = s[x][i];
					break;
				}
			if (res[p]==null) {
				ok  = false;
				break;
			}
		}
		p++;
	}
	if (ok)
		for (String ss: res) out.println(ss);
	else
		out.println("IMPOSSIBLE");

	
	
}
}





