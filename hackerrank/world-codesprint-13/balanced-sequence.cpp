// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vii;
typedef vector<string> vs;
typedef vector<vector<int> > vvi;
typedef vector<ll> vl;
typedef vector<vector<ll> > vvl;
#define forn(i,n) for(int i=0;i<(n);++i)
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define sz(x) ((int)(x).size())
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on




int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n;
    string s;
    cin >> n >> s;
    int b1 = 0, b2 = 0;
    bool ok1 = true, ok2 = true;
    for (char c:s)
        if (c == '(') b1++;
        else {
            b1--;
            if (b1 < 0) ok1 = false;
        }
    for (int i = n - 1; i >= 0; --i) {
        if (s[i] == ')') b2++;
        else {
            b2--;
            if (b2 < 0) ok2 = false;
        }

    }

    if (ok1 || ok2) {
        if (b1 == 0 && b2 == 0) cout << 0; else cout << 1;
    } else {
        cout << 2;
    }
    return 0;
}