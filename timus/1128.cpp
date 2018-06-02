#include <string>      
#include <vector>      
#include <cmath>      
#include <queue>      
#include <set>      
#include <stack> 
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
 
using namespace std;      
VI a[8000];
int f[8000];
int main(){      
  
	int n;
	cin >> n;
	for (int i=1; i<=n; i++) {
		int k,x;
		scanf("%d",&k);
		while (k--) {
			scanf("%d",&x);
			a[i].pb(x);
		}
	}
	bool ok = false;
	while (!ok) {
		ok = true;
		for(int i=1; i<=n; i++) {
			int t = 0;
			forv(j,a[i]) if (f[a[i][j]]==f[i]) t++;
			if (t>1) {
				ok = false;
				f[i] = 1-f[i];
			}
		}
	}
	VI v1, v2;
	for (int i=1; i<=n; i++) 
		if (f[i]) v1.pb(i); else v2.pb(i);
	if (sz(v1)<sz(v2) || (sz(v1)==sz(v2) && v1[0]==1)) {
		cout << sz(v1) << endl;
		forv(i,v1) cout << v1[i] <<" ";
	} else {
		cout << sz(v2) << endl;
		forv(i,v2) cout << v2[i] <<" ";
	}
    return 0;      
}  
