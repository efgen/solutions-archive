import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
//int inf = 1000000000;   
double eps = 1e-10;

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
	int n = Integer.parseInt(br.readLine());
	String[] str = new String[n];
	String[] str1 = new String[n];
	String[] str2 = new String[n];
	for (int i=0; i<n; i++) {
		String[]ss = br.readLine().toLowerCase().split("-");
		str[i] = ss[0]+ss[1];
		str1[i] = ss[0];
		str2[i] = ss[1];
	}
	while (true) {
		String line = br.readLine();
		if (line==null) break;
		if (line.length()==0) {
			out.println();
			continue;
		}
		char[] s = line.toCharArray();
		int pos = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();
	
		while (pos<s.length) {
			while (pos<s.length && sb.length()<40 && !( (s[pos]>='a' && s[pos]<='z') ||  (s[pos]>='A' && s[pos]<='Z')))
				sb.append(s[pos++]);
			if (sb.length()==40) {
				out.println(sb.toString());
				sb.setLength(0);
				continue;
			}			
			word.setLength(0);
			while (pos<s.length  && ( (s[pos]>='a' && s[pos]<='z') ||  (s[pos]>='A' && s[pos]<='Z')))
				word.append(s[pos++]);
			if (word.length()+sb.length()<=40) sb.append(word); else {
				String w = word.toString().toLowerCase();
				int r = -1;
				for (int i=0; i<n; i++) 
					if (w.endsWith(str[i]) && w.length()-str2[i].length()+sb.length()<40)
						if (r<0 || str2[i].length()<str2[r].length()) r = i;
				w = word.toString();
				if (r>=0) {
					sb.append(w.substring(0, w.length()-str2[r].length()));
					sb.append('-');
					w = w.substring(w.length()-str2[r].length());
				}
				out.println(sb.toString());
				sb.setLength(0);
				sb.append(w);
			}
			
		}
		if (sb.length()>0) out.println(sb.toString());
	}
		
}
}







