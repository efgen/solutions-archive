// @formatter:off
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

const int inf = 1000000000 + 1234;

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, m;
    cin >> m >> n;
    vi a(n + 1), s(n + 1), m1(n + 1), m2(n + 1), d1(n + 1), d2(n + 1);
    while (m--) {
        for (int i = 1; i <= n; i++) {
            cin >> a[i];
            s[i] = s[i - 1] + a[i];
        }
        int min_pos = 0;
        for (int i = 1; i <= n; i++) {
            if (s[i] < s[min_pos]) min_pos = i;
            m1[i] = min_pos;
        }
        int max_pos = n;
        for (int i = n; i > 0; --i) {
            if (s[i] > s[max_pos]) max_pos = i;
            m2[i] = max_pos;
        }
        int val_r = -inf;
        for (int i = 1; i <= n; i++) {
            int tl = s[i - 1] - s[m1[i - 1]];
            int tr = s[m2[i]] - s[i];
            val_r = max(val_r + a[i], tl + d1[i] + a[i]);
            d2[i] = val_r + tr;
        }


        int val_l = -inf;
        for (int i = n; i > 0; i--) {
            int tl = s[i - 1] - s[m1[i - 1]];
            int tr = s[m2[i]] - s[i];
            val_l = max(val_l + a[i], tr + d1[i] + a[i]);
            d2[i] = max(d2[i], val_l + tl);
        }

        for (int i = 1; i <= n; i++) {
            d1[i] = d2[i];
        }
    }
    int res = -inf;
    for (int i = 1; i <= n; i++) {
        res = max(res, d1[i]);
    }
    cout << res;


    return 0;
}


