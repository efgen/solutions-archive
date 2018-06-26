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
    int n, k;
    cin >> n >> k;
    map<ll, int> cnts;
    forn(i, n) {
        ll x;
        cin >> x;
        x -= ((ll) k) * i;
        cnts[x]++;
    }
    int res = 0;
    for (auto kv:cnts) res = max(res, kv.second);
    cout << n - res << endl;
    return 0;
}
