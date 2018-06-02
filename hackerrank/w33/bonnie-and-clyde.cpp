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
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on


struct lca {
    int n, len;
    vi tin, tout, component;
    vvi up;

    lca(const vvi &tree) {
        n = tree.size();
        len = 1;
        while ((1 << len) <= n) len++;
        up.assign(n, vi(len));
        tin.assign(n, 0);
        tout.assign(n, 0);
        component.assign(n, 0);

        function<void(int, int, int &, int)> dfs = [&](int u, int p, int &t, int number) {
            component[u] = number;
            tin[u] = ++t;
            up[u][0] = p;
            for (int i = 1; i < len; i++)
                up[u][i] = up[up[u][i - 1]][i - 1];
            for (int v : tree[u])
                if (v != p)
                    dfs(v, u, t, number);
            tout[u] = ++t;
        };

        int timer;
        int comps = 0;
        forn(i, n) {
            if (!tin[i]) {
                timer = 0;
                dfs(i, i, timer, ++comps);
            }
        }
    }

    int get_component(int u) {
        return component[u];
    }

    int get_parent(int u) {
        return up[u][0];
    }

    bool is_parent(int parent, int child) {
        return tin[parent] <= tin[child] && tout[child] <= tout[parent];
    }

    bool on_way(int x, int y, int z) {
        return is_parent(z, x) && is_parent(y, z);
    }

    int query(int a, int b) {
        if (is_parent(a, b))
            return a;
        if (is_parent(b, a))
            return b;
        for (int i = len - 1; i >= 0; i--)
            if (!is_parent(up[a][i], b))
                a = up[a][i];
        return up[a][0];
    }
};

struct graph {
    int n;
    vvi adj;

    graph(int n) : n(n), adj(n) {}

    void add_edge(int u, int v) {
        //cout << u << " " << v << endl;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int add_node() {
        adj.push_back({});
        return n++;
    }

    vi &operator[](int u) { return adj[u]; }
};

pair<vi, vvi> biconnected_components(graph &adj) {
    int n = adj.n;

    vi num(n), low(n), art(n);
    stack<int> stk;
    vvi comps;

    function<void(int, int, int &)> dfs = [&](int u, int p, int &t) {
        num[u] = low[u] = ++t;
        stk.push(u);

        for (int v : adj[u])
            if (v != p) {
                if (!num[v]) {
                    dfs(v, u, t);
                    low[u] = min(low[u], low[v]);

                    if (low[v] >= num[u]) {
                        art[u] = (num[u] > 1 || num[v] > 2);

                        comps.push_back({u});
                        while (comps.back().back() != v)
                            comps.back().push_back(stk.top()), stk.pop();
                    }
                } else {
                    low[u] = min(low[u], num[v]);
                }
            }
    };

    for (int u = 0, t; u < n; ++u)
        if (!num[u]) dfs(u, -1, t = 0);

    return {art, comps};
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, m, q;
    scanf("%d%d%d", &n, &m, &q);
    graph g(n);
    forn(i, m) {
        int x, y;
        scanf("%d%d", &x, &y);
        g.add_edge(x - 1, y - 1);
    }
    auto res = biconnected_components(g);

    graph tree(0);
    vi id(n);

    forn(u, n) {
        if (res.X[u]) {
            id[u] = tree.add_node();
        }
    }

    for (auto &comp : res.Y) {
        int node = tree.add_node();
        for (int u : comp)
            if (!res.X[u]) {
                id[u] = node;
            } else {
                tree.add_edge(node, id[u]);
            }
    }

    lca L(tree.adj);
    forn(i, q) {
        int x, y, z;
        scanf("%d%d%d", &x, &y, &z);
        x--;
        y--;
        z--;
        x = id[x];
        y = id[y];
        int ancestor = L.query(x, y);
        bool ok = false;
        if (L.get_component(x) == L.get_component(y) && L.get_component(x) == L.get_component(id[z])) {
            ok = L.on_way(x, ancestor, id[z]) || L.on_way(y, ancestor, id[z]);
            if (res.X[z]) {
                int pz = L.get_parent(id[z]);
                ok |= L.on_way(x, ancestor, pz) || L.on_way(y, ancestor, pz);
                if (L.get_parent(ancestor) == id[z]) ok = true;
            }
        }

        cout << (ok ? "YES" : "NO") << endl;
    }
    return 0;
}

