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
    int n = 26;
    vi a(n);
    int tests;
    cin >> tests;
    while (tests--) {
        forn(i, n) cin >> a[i];
        ll sum = 0, res = 0, L = 0, R = 0;
        forn(i, n) sum += a[i];
        ll need = sum / 2 + 1;

        forn(i, n) {
            R = sum - a[i] - L;
            ll t = a[i];

            if (t + L > need) {
                ll k = min(t, t + L - need);
                t -= k;
                k = min(L - 1, k);
                ll up = t + L - 1 - k;
                res = max(res, k + min(R, up));
            } else {
                res = max(res, min(t + L - 1, R));
            }


            L += a[i];
        }
        cout << res << endl;

    }


    return 0;
}
