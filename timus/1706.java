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
    //	br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(System.out);
    	//out = new PrintWriter(new FileWriter("output.txt"));
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
   
    }
}

char[] s;
int[] p;
int kmp(int start, int len) {
	Arrays.fill(p, 0);
	int q = 0;
	int res = 0;
	for (int i = 1; i<len; i++) {
		while (q>0 && s[start+i]!=s[start+q]) q = p[q-1];
		if (s[start+i]==s[start+q]) q++;
		p[i] = q;
		if (q>res) res = q;
	}
	return res;
}

int kmpb(int start, int len) {
	Arrays.fill(p, 0);
	int q = 0;
	int res = 0;
	for (int i = 1; i<len; i++) {
		while (q>0 && s[start-i]!=s[start-q]) q = p[q-1];
		if (s[start-i]==s[start-q]) q++;
		p[i] = q;
		if (q>res) res = q;
	}
	return res;
}


public void solve() throws IOException {
	int k = Integer.parseInt(br.readLine());
	String ss = br.readLine();
	int len = ss.length();
	s = (ss+ss).toCharArray();	
	p = new int[len];
	int res = 0;
	for (int i=0; i<k; i++) res += i+1-kmpb(i, i+1);
	out.print(res+" ");
	for (int i=k; i<len+k-1; i++) {
		res -= k+1-kmp(i-k, k);
		res += k+1-kmpb(i, k);
		out.print(res+" ");
	}

}      
} 
//785478606870985
//599619145623741


//2323218950659046189161096883702440585