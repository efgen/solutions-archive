import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
//Scanner in;   
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

boolean inComment = false;
boolean inString = false;
char[] s;
int pos, len;
void parse() {
	if (inComment) commentSK();
	if (inString) string();
	while (pos<len) {
		if (s[pos]>='0' && s[pos]<='9') number(); else
		if (s[pos]=='\'') {
			out.print("<span class=string>");
			out.print(s[pos++]);
			string(); 		
		} else
		if (pos<len-1 && s[pos]=='#' && s[pos+1]>='0' && s[pos+1]<='9') ebostring(); else
		if ((s[pos]>='a' && s[pos]<='z') || (s[pos]>='A' && s[pos]<='Z') || s[pos]=='_') identificator(); else		
		if (pos<len-2 && s[pos]=='/' && s[pos+1]=='/') { 
			out.print("<span class=comment>");
			commentPP();
			out.println();
			return;
		} else
		if (s[pos]=='{') {
			out.print("<span class=comment>");
			commentSK();
		} else out.print(s[pos++]);
	}
	out.println();
}
void string() {
	inString = true;	
	while (pos<len && s[pos]!='\'') out.print(s[pos++]);
	if (pos<len && s[pos]=='\'') {
		out.print(s[pos++]);
		out.print("</span>");
		inString = false;
	}
}

void ebostring() {
	out.print("<span class=string>");
	out.print(s[pos++]);
	while (pos<len && s[pos]>='0' && s[pos]<='9') out.print(s[pos++]);
	out.print("</span>");
}
void number() {
	out.print("<span class=number>");
	while (pos<len && s[pos]>='0' && s[pos]<='9') out.print(s[pos++]);
	if (pos<len-1 && s[pos]=='.' && s[pos+1]>='0' && s[pos+1]<='9') out.print(s[pos++]);	
	while (pos<len && s[pos]>='0' && s[pos]<='9') out.print(s[pos++]);
	out.print("</span>");
}

HashSet<String> keywords = new HashSet<String>();

void identificator() {
	StringBuilder sb = new StringBuilder();
	while (pos<len && ((s[pos]>='a' && s[pos]<='z') || (s[pos]>='A' && s[pos]<='Z') || (s[pos]>='0' && s[pos]<='9') || s[pos]=='_'))
		sb.append(s[pos++]);
	if (sb.length()<15 && keywords.contains(sb.toString().toLowerCase())) {
		out.print("<span class=keyword>");
		out.print(sb.toString());
		out.print("</span>");
	} else 
		out.print(sb.toString());
}

void commentSK() {
	inComment = true;
	while (pos<len && s[pos]!='}') out.print(s[pos++]);
	if (pos<len){
		out.print(s[pos++]);
		out.print("</span>");
		inComment = false;
	}
}
void commentPP() {
	while (pos<len) out.print(s[pos++]);
	out.print("</span>");
}
public void solve() throws IOException {
	String[] keys = {"and", "array", "begin", "case", "class", "const", "div", "do", "else", "end", "for", "function", "if", "implementation", "interface", "mod", "not", "of", "or", "procedure", "program", "record", "repeat", "shl", "shr", "string", "then", "to", "type", "unit", "until", "uses", "var", "with", "while"};
	for (String ss:keys) keywords.add(ss);	
	while (true) {
		String line = br.readLine();
		if (line==null) break;
		s = line.toCharArray();
		len = s.length;
		pos = 0;
		parse();
	}
	
}
}







