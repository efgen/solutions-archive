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
//    	br = new BufferedReader(new FileReader(new File(filename+".in")));
//   	out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
//    	br = new BufferedReader(new FileReader(new File("input.txt")));
//    	out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    	//in = new Scanner(br);
        //ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

public void solve() throws IOException {
	char[] s = ("."+br.readLine()).toCharArray();
	int n = s.length-1;
	int[] f = new int[n+1];
	String[] sss = br.readLine().split(" ");
	boolean ok = true;
	int pos = 1;
	for (String ss:sss) {
		int st = pos;
		char[] p = ("."+ss).toCharArray();
		int m = p.length-1;
		if (m>n) {
			ok = false;
			break;
		}
		int q = 0;
		for (int i=2; i<=m; i++) {
			while (q>0 && p[i]!=p[q+1]) q = f[q];
			if (p[i]==p[q+1]) q++;
			f[i] = q;
		}
		q = 0;
		while (pos<=n && q<m) {
			while (q>0 && s[pos]!=p[q+1]) q = f[q];
			if (s[pos]==p[q+1]) q++;
			pos++;			
		}
		
		if (q==m) {
			for (int i=st; i<pos-m; i++) if (s[i]!=' ') s[i] = '_';
			if (pos<=n && s[pos]!=' ') s[pos] = '_';
			pos++;
		} else {
			ok = false;
			break;
		}
			
	}
	if (ok) {
		for (int i=pos; i<=n; i++) if (s[i]!=' ') s[i] = '_';
		for (int i=1; i<=n; i++) out.print(s[i]);
	} else {
		out.println("I HAVE FAILED!!!");
	}
	


}
}





