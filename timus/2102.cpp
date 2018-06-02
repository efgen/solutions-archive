#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<string> vs;
typedef vector<vector<int> > vvi;
typedef vector<ll> vl;
typedef vector<vector<ll> > vvl;

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back



int main() {
	ll n;
	cin >> n;
	int cnt = 0;
	while (n%2==0) { n/=2; cnt++; }		
	ll p = 3;
	while (n>1 && p<3000000) {
		while (n%p==0) { n/=p; cnt++; }		
		if (p*p>n) p = n; else p += 2;
	}	
	if ((cnt==20 && n==1) || (cnt==19 && n>1)) cout << "Yes"; else cout << "No";

}
