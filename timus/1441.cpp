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
#define min(a,b) ((a<b):a:b)   
using namespace std;      

int n,m;
set<int> a[20001];
int d[20001];
int p = 0;
int S[200000];
int t = 0;
void dfs2(int v) {
	S[t++] = v;	
	while (t>0) {
		v = S[t-1];		
		if (sz(a[v])==0) {
			t--;
			if (v==0) p = 1; else {
				if (p) printf("\n");
				p = 0;
				printf("%d ",v);				
			}
			continue;
		}
		int x = *a[v].begin();
		a[x].erase(v);
		a[v].erase(x);
		S[t++] = x;
	}
	
}
int main(){      
 
	cin >> n >> m;
	forn(i,n+1) d[i] = 0;
	while (m--) {
		int x,y;
		scanf("%d%d",&x,&y);
		d[x]++; d[y]++;
		a[x].insert(y);
		a[y].insert(x);	
	}
	int res = 0;
	for (int i=1; i<=n; i++)
		if (d[i]&1)  {
			res++;
			a[0].insert(i);
			a[i].insert(0);		
		}
	if (res==0) {
		cout << 1 << endl;
		dfs2(1);
	} else {
		cout << res/2;
		dfs2(0);	
	}
    return 0;      
}  
