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

char s[8];
int data[maxn];
ll top[1001];
unsigned char a[12501*17];
int main(){      
 //   freopen("input.txt","r",stdin);      
  //  freopen("output.txt","w",stdout);
	int x,y;
	scanf("%d%d",&x,&y);
	cout << x+y;
	return 0;   
}  
