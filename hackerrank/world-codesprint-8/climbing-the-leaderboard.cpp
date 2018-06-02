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
	int n, m;
	vi a;
	cin >> n;
	forn(i, n) {
		int x;
		cin >> x;
		if (i == 0 || x != a[a.size() - 1]) {
			a.pb(x);
		}
	}
	int pos = a.size() - 1;
	cin >> m;
	forn(i, m) {
		int x;
		cin >> x;
		while (pos >= 0 && a[pos] <= x) pos--;
		cout << pos + 2 << endl;
	}
}

