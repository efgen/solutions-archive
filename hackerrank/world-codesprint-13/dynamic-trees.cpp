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

vi color, pr;


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, q;
    cin >> n >> q;
    color.assign(n, 0);
    pr.assign(n, -1);
    forn(i, n) cin >> color[i];
    for (int i = 1; i < n; i++) {
        cin >> pr[i];
        pr[i]--;
    }
    while (q--) {
        string qt;
        cin >> qt;
        if (qt[0] == 'T') {
            int x;
            cin >> x;
            x--;
            color[x] ^= 1;
        }
        if (qt[0] == 'C') {
            int v, p;
            cin >> v >> p;
            v--;
            p--;
            pr[v] = p;
        }
        if (qt[0] == 'K') {
            int x, y, k;
            cin >> x >> y >> k;
            x--;
            y--;
            vi f(n, 0);
            int t = x;
            while (t >= 0) {
                f[t] = true;
                t = pr[t];
            }
            t = y;
            stack<int> path;
            while (!f[t]) {
                path.push(t);
                t = pr[t];
            }
            int L = t;
            t = x;
            while (t != L) {
                if (color[t]) k--;
                if (k == 0) break;
                t = pr[t];
            }
            while (k > 0 && !path.empty()) {
                t = path.top();
                path.pop();
                if (color[t]) k--;
            }
            if (k == 0) cout << t + 1; else cout << -1;
            cout << endl;

        }
    }

    return 0;
}