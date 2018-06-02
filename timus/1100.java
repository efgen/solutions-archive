import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

//Scanner in;
	StreamTokenizer in;	
PrintWriter out;
class Data {
	int id;
	int key;
}
class Cmp implements Comparator {
	public int compare (Object o1,Object o2) {
		Data x = (Data) o1;
		Data y = (Data) o2;
		return ((Integer)y.key).compareTo((Integer)x.key);
	}	
}

public static void main(String[] args) throws IOException {
new Main().run();
}
int nextInt() throws IOException
{
   in.nextToken();
   return (int)in.nval;
}

public void run() throws IOException {
  //in = new Scanner(System.in); in.useLocale(Locale.US);  
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  out = new PrintWriter(System.out); 
  int n = nextInt();
  Data[] a = new Data[n];
  for (int i=0; i<n; i++) {
	  a[i] = new Data();
	  a[i].id = nextInt();
	  a[i].key = nextInt();
  }
  Arrays.sort(a, new Cmp());
  for (int i=0; i<n; i++)
	  out.println(a[i].id+" "+a[i].key);
  
 
 // in.close(); 
  out.close();
}

}


