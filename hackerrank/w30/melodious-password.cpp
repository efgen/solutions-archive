#include <cmath>
#include <cstdio>
#include <set>
#include <string>
#include <iostream>
#include <algorithm>
using namespace std;
set<char> vol = {'a', 'e', 'i', 'o', 'u'};
char s[10];
int n;
void gen(int k, bool f) {    
    if (k==n) {        
        cout << s << endl;
        return;
    }
    f = !f; 
    for(char c='a'; c<='z'; c++) {
        if (c=='y') continue;
        if (f ^ vol.count(c)) {
            continue;
        }    
        s[k] = c;
        gen(k+1, f);
    }    
}
int main() {  
    cin >> n;
    gen(0, false);
    gen(0, true);
    return 0;
}
