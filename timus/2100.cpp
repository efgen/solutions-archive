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
	int q;
	cin >> q;
	int cnt = q+2;
	while (q--) {
		string s;
		cin >> s;
		if (any_of(all(s), [](char c){return c=='+';})) cnt++;		
	}
	if (cnt==13)cnt++;
	cout << cnt << "00";
		
	
}
