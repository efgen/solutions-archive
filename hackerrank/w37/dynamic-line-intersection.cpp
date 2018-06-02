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
    cin >> n;
    map<int, map<int, int>> lines;
    int maxn = 100000 + 10;
    vi cnt(maxn);
    int bound = (int) sqrt(maxn);
    forn(i, n) {
        string s;
        int k, b, q;
        cin >> s;
        if (s[0] == '?') {
            cin >> q;
            int res = 0;
            for (int k = 0; k <= bound; k++) {
                if (lines.count(k)) {
                    res += lines[k][q % k];
                }
            }

            cout << res + cnt[q] << endl;
        } else {
            cin >> k >> b;
            b %= k;

            if (k > bound) {
                for (int x = b; x < maxn; x += k) {
                    if (s[0] == '+') cnt[x]++; else cnt[x]--;
                }
            } else {
                if (s[0] == '+') lines[k][b]++; else lines[k][b]--;
            }
        }

    }
    return 0;
}
