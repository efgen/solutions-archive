#include <string>      
#include <vector>      
#include <cmath>      
#include <queue>      
#include <set>      
#include <map>      
#include <algorithm>      
#include <iostream>      
#include <cstdio>      
#include <sstream>      
  
#define sz(a) ((int)(a).size())   
#define forn(i, n) for (int i = 0; i < (int)(n); ++i)      
#define forv(i, v) for (int i = 0; i < sz(v); ++i)      
#define fors(i, s) for (int i = 0; i < (int)(s.length()); ++i)      
#define fe(it,a) for(typeof(a.begin()) it = a.begin(); it != a.end(); it++)   
#define all(a) (a).begin(), (a).end()      
#define pb push_back      
#define PII pair<int, int>      
#define mp make_pair      
#define VI vector<int>      
#define VS vector<string>   
#define LL long long 
#define min(a,b) ((a<b):a:b)   
using namespace std;      

int n;
int a[100][100];

int main(){      
  
	while (true) {
		scanf("%d",&n);
		if (n==0) break;
		forn(i,n) forn(j,n) scanf("%d",&a[i][j]);
		int sz = n;
		if ((n&1)==0) sz--;
		bool f = false;
		while (sz>1 && !f) {		
			int L = sz/2;
			int R = 3*L;
			for (int i=0; i<=n-sz && !f; i++)
				for (int j=0; j<=n-sz; j++) {
					f = true;
					for (int x=0; f && x<sz; x++) for (int y=0; f && y<sz; y++)
						if (x+y>=L && x+y<=R && x-y>=-L && x-y<=L)
							f &= !a[i+x][j+y];
						else
							f &= a[i+x][j+y];
					if (f) {
						cout << sz;
						break;
					}
				}
			sz -= 2;		
		}
		if (!f) cout << "No solution";
		cout << endl;
	}

    return 0;      
}  
