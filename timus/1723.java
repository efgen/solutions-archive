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
	int[] a = new int[26];
	for (char c:br.readLine().toCharArray()) a[c-'a']++;
	int r = 0;
	for (int i=0; i<26; i++) if (a[i]>a[r]) r = i;
	out.println((char)(r+'a'));
}
}





