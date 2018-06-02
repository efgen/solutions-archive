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
#include <utility>

#define sz(a) ((int)(a).size())
#define forn(i, n) for (int i = 0; i < (int)(n); ++i)   
#define forv(i, v) for (int i = 0; i < sz(v); ++i)   
#define fors(i, s) for (int i = 0; i < (int)(s.length()); ++i)   
#define fe(it,a) for(typeof(a.begin()) it = a.begin(); it != a.end(); it++)
#define all(a) (a).begin(), (a).end()   
#define pb push_back   
#define ii pair<int, int>   
#define mp make_pair   
#define vi vector<int>   
#define vs vector<string>
#define min(a,b) ((a<b):a:b)
#define ll long long
const int  maxn = 100001;  
using namespace std;      
int sz = 0;
char s[8];
int data[maxn];
int top[1000];
unsigned char a[12501*17];
inline void setbit1(int p) {
	a[p>>3] |= 1<<(p&7);
}
inline void setbit0(int p) {
	a[p>>3] &= 255^(1<<(p&7));
}
inline int getbit(int p) {
	return a[p>>3]&(1<<(p&7))?1:0;
}
inline int getA(int p) {	
	p = (p-1)*17;
	int res = 0;
	for (int i=16; i>=0; i--,p++) {
		res <<= 1;
		res |= getbit(p);	
	}
	return res;	
}

inline void setA(int p, int x) {	
	p *= 17;	
	for (int i=16; i>=0; i--) {		
		p--;
		if (x&1) 
			setbit1(p); 
		else 
			setbit0(p);
		x >>= 1;
	}
}
int main(){      
 //   freopen("input.txt","r",stdin);      
 //   freopen("output.txt","w",stdout);
	forn(i,1000)  top[i] = 0;
	int oper,x,t,code;	
	scanf("%d",&oper);	
	while (oper--) {
		scanf("%s",s);
		if (s[1]=='U') {
			scanf("%d%d",&t,&x); t--;
			data[++sz] = x;						
			//a[sz] = top[t]; //
			setA(sz,top[t]);
			top[t] = sz;
		} else {
			scanf("%d",&t); t--;
			printf("%d\n",data[top[t]]);
			//top[t] = a[top[t]] //
			top[t] = getA(top[t]);
		}
	}	
	return 0;   
}  
