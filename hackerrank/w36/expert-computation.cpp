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
const int inf = 1 << 30;
const int mod = 1000000000 + 7;
#define F(x) ((x)?(h[x]*C-c[x]*H):(1L<<63))

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n;
    scanf("%d", &n);
    vi x(n + 1), y(n + 1), z(n + 1), f(n + 1), g(n + 1), c(n + 1), h(n + 1), l(n + 1);
    forn(i, n) scanf("%d", &x[i + 1]);
    forn(i, n) scanf("%d", &y[i + 1]);
    forn(i, n) scanf("%d", &z[i + 1]);
    vector<vi> go(21, vi(n + 1, 0));
    stack<int> st;

    for (int i = 1; i <= n; i++) {
        h[i] = x[i] ^ g[i - 1];
        c[i] = y[i] ^ g[i - 1];
        l[i] = z[i] ^ g[i - 1];
        ll C = c[i];
        ll H = h[i];
        while (!st.empty() && c[i] <= c[st.top()]) st.pop();
        while (st.size() > 1) {
            ll x1 = h[i] - h[st.top()];
            ll y1 = c[i] - c[st.top()];
            int mid = st.top();
            st.pop();
            ll x2 = h[mid] - h[st.top()];
            ll y2 = c[mid] - c[st.top()];
            if (x1 * y2 - x2 * y1 <= 0) {
                st.push(mid);
                break;
            } else {
                continue;
            }
        }
        int v = 0;
        if (!st.empty()) v = st.top();
        st.push(i);
        int k = 0;
        while (v != 0) {
            go[k][i] = v;
            v = go[k][v];
            k++;
        }


        int t = i - l[i];
        ll res = F(t);

        while (t > 0) {
            k = 0;
            ll v1 = F(t);
            ll v2 = F(go[0][t]);
            ll v3 = F(go[1][t]);
            do {
                if (v1 < v2 && v2 < v3) {
                    k++;
                    v1 = v2;
                    v2 = v3;
                    v3 = F(go[k+1][t]);
                } else break;
            } while (k <= 20);
            t = go[k == 0 ? 0 : k - 1][t];
            ll val = F(t);
            if (val < res) break;
            res = val;
        }

        res %= mod;
        res = (res + mod) % mod;
        f[i] = (int) (res);
        g[i] = (g[i - 1] + f[i]) % mod;

    }
    cout << g[n];
    return 0;
}
