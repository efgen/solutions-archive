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
#define forv(i,v) forn(i,sz(v))
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define sz(x) x.size()
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on

string s, p, p_rev;
vvi aut[2];
int plen = 0;

struct lca {
    int n, len;
    vi tin, tout, h;
    vvi up;
    vi match[2];


    lca(const vvi &tree) {
        n = tree.size();
        len = 1;
        while ((1 << len) <= n) len++;
        up.assign(len, vi(n));

        forn(k, 2) {
            match[k].assign(n, 0);
        }

        tin.assign(n, 0);
        tout.assign(n, 0);
        h.assign(n, 0);

        function<void(int, int, int &)> dfs = [&](int u, int parent, int &t) {
            tin[u] = ++t;
            up[0][u] = parent;
            for (int i = 1; i < len; i++) {
                up[i][u] = up[i - 1][up[i - 1][u]];
            }
            forn(k, 2) {
                if (h[u] < plen) break;
                bool ok = true;
                int v = u;
                forn(i, plen) {
                    if (s[v] != (k ? p_rev[i] : p[i])) {
                        ok = false;
                        break;
                    }
                    v = up[0][v];
                }
                match[k][u] = ok ? 1 : 0;
                match[k][u] += match[k][up[0][u]];
            }
            for (int v : tree[u])
                if (v != parent) {
                    h[v] = h[u] + 1;
                    dfs(v, u, t);
                }

            tout[u] = ++t;
        };

        int timer = 0;
        int start = n-1;
        dfs(start, start, timer);
    }

    bool is_parent(int parent, int child) {
        return tin[parent] <= tin[child] && tout[child] <= tout[parent];
    }

    int query_lca(int a, int b) {
        if (is_parent(a, b))
            return a;
        if (is_parent(b, a))
            return b;
        for (int i = len - 1; i >= 0; i--)
            if (!is_parent(up[i][a], b))
                a = up[i][a];
        return up[0][a];
    }

    int go_up(int v, int h) {
        for (int i = len - 1; h && (i >= 0); i--)
            if ((1 << i) <= h) {
                v = up[i][v];
                h -= (1 << i);
            }
        return v;
    }
};

vi prefix_function(string s) {
    int n = s.length();
    vi pi(n);
    for (int i = 1; i < n; ++i) {
        int k = pi[i - 1];
        while (k > 0 && s[i] != s[k])
            k = pi[k - 1];
        if (s[i] == s[k]) k++;
        pi[i] = k;
    }

    return pi;
}

vvi build(string p) {
    int plen = p.length();
    p += (char) (26);
    vi pi = prefix_function(p);
    vvi aut(plen + 1, vi(27));
    forn(i, plen + 1) {
        forn(c, 27) {
            if (i > 0 && c != p[i])
                aut[i][c] = aut[pi[i - 1]][c];
            else
                aut[i][c] = i + (c == p[i]);
        }
    }
    return aut;
}


vi path;

int dummy(int x, int y, int anc, const lca &L, const vi &parent) {
    int pos = 0, ans = 0;
    while (x != anc) {
        pos = aut[0][pos][s[x]];
        if (pos == plen) ans++;
        x = parent[x];
    }
    pos = aut[0][pos][s[x]];
    if (pos == plen) ans++;
    int k = L.h[y] - L.h[anc];
    int len = k;
    while (y != anc) {
        path[--k] = y;
        y = parent[y];
    }

    forn(i, len) {
        pos = aut[0][pos][s[path[i]]];
        if (pos == plen) ans++;
    }

    return ans;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    int n, q;
    cin >> n >> q >> s >> p;
    for (char &c:s) c -= 'a';
    for (char &c:p) c -= 'a';
    vvi tree(n, vi());
    forn(i, n - 1) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        tree[x].pb(y);
        tree[y].pb(x);
    }

    plen = p.length();
    aut[0] = build(p);
    p_rev = p;
    reverse(all(p_rev));
    aut[1] = build(p_rev);

    lca L(tree);
    path.assign(n, 0);
    while (q--) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        int anc = L.query_lca(x, y);
        int ans = 0;
        int h1 = L.h[x] - L.h[anc];
        int h2 = L.h[y] - L.h[anc];

        int p1 = x, p2 = y;
        if (h1 >= plen) {
            p1 = L.go_up(x, h1 - plen + 1);
            ans += L.match[0][x] - L.match[0][p1];
        }
        if (h2 >= plen) {
            p2 = L.go_up(y, h2 - plen + 1);
            ans += L.match[1][y] - L.match[1][p2];
        }

        ans += dummy(p1, p2, anc, L, L.up[0]);

        cout << ans << endl;
    }
    return 0;
}

