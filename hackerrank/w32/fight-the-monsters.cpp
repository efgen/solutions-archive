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
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ll n, hit, t;
    cin >> n >> hit >> t;
    vl a(n);
    forn(i, n) cin >> a[i];
    sort(all(a));
    ll cnt = 0;
    for(int x:a) {
        t -= (x+hit-1)/hit;
        if (t>=0) cnt++;
    }
    cout << cnt;
}
