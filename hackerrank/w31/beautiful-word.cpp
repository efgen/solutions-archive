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

bool isVowel(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'y';
}

int main() {
	string s;
	cin >> s;
	bool ok = true;	
	char last = '.';
	for (char c:s) {
		if (c==last) ok = false;
		if (isVowel(last) && isVowel(c)) ok = false;
		last = c;
	}
	if (ok) cout << "Yes"; else cout << "No";			
}
