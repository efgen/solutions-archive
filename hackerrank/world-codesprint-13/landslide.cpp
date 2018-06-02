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

int n;
vvi tree;


struct lca {
    int n, len;
    vi tin, tout, h;
    vvi up;

    lca(const vvi &tree) {
        n = tree.size();
        len = 1;
        while ((1 << len) <= n) len++;
        up.assign(len, vi(n));

        tin.assign(n, 0);
        tout.assign(n, 0);
        h.assign(n, 0);

        function<void(int, int, int &)> dfs = [&](int u, int parent, int &t) {
            tin[u] = ++t;
            up[0][u] = parent;
            for (int i = 1; i < len; i++) {
                up[i][u] = up[i - 1][up[i - 1][u]];
            }

            for (int v : tree[u])
                if (v != parent) {
                    h[v] = h[u] + 1;
                    dfs(v, u, t);
                }

            tout[u] = ++t;
        };

        int timer = 0;
        int start = 0;
        dfs(start, start, timer);
    }

    bool is_parent(int parent, int child) {
        return tin[parent] <= tin[child] && tout[child] <= tout[parent];
    }

    bool is_real_parent(int parent, int child) {
        return is_parent(parent, child) && h[child] == h[parent] + 1;
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

    int distance(int x, int y, int v) {
        return h[x] + h[y] - 2 * h[v];
    }
};

map<pii, int> edge_id;
vi first, edges, edge_mark;
vi first1, first2, tree1, tree2;
int dfs_time;

void dfs(int v) {
    first[v] = dfs_time++;
    for (int x:tree[v])
        if (first[x] < 0) {
            int e = edge_id.size();
            edge_id[{x, v}] = e;
            edges.pb(e);
            dfs(x);
            edges.pb(e);
            dfs_time++;
        }
}

void prepare() {
    first.assign(n, -1);
    dfs(0);
    first1.resize(n, -1);
    first2.resize(n, -1);
    for (int i = 0; i < edges.size(); i++) {
        int e = edges[i];
        if (first1[e] < 0) first1[e] = i; else first2[e] = i;
    }
    tree1.resize(edges.size() * 8);
    tree2.resize(edges.size() * 8);
    edge_mark.resize(edges.size());
}


void sum_tree_update(vector<int> &tree, int i, int l, int r, int j, int delta) {
    tree[i] += delta;
    if (l < r) {
        int m = (l + r) >> 1;
        if (j <= m)
            sum_tree_update(tree, i + i, l, m, j, delta);
        else
            sum_tree_update(tree, i + i + 1, m + 1, r, j, delta);
    }
}

int sum_tree_query(const vector<int> &tree, int i, int tl, int tr, int l, int r) {
    if (l > r || tl > tr) return 0;
    if (tl == l && tr == r)
        return tree[i];
    int m = (tl + tr) >> 1;
    if (r <= m)
        return sum_tree_query(tree, i + i, tl, m, l, r);
    if (l > m)
        return sum_tree_query(tree, i + i + 1, m + 1, tr, l, r);
    return sum_tree_query(tree, i + i, tl, m, l, m)
           + sum_tree_query(tree, i + i + 1, m + 1, tr, m + 1, r);
}

void mark(int p, int v, int add) {
    int e = edge_id[{v, p}];
    if (edge_mark[e] > 0 && add > 0) return;
    if (edge_mark[e] == 0 && add < 0) return;
    edge_mark[e] += add;
    sum_tree_update(tree1, 1, 0, edges.size() - 1, first1[e], add);
    sum_tree_update(tree2, 1, 0, edges.size() - 1, first2[e], add);
}

int query(int v1, int v2) {
    return sum_tree_query(tree1, 1, 0, edges.size() - 1, first[v1], first[v2] - 1)
           - sum_tree_query(tree2, 1, 0, edges.size() - 1, first[v1], first[v2] - 1);
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n;
    tree.assign(n, vi());
    forn(i, n - 1) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        tree[x].pb(y);
        tree[y].pb(x);
    }
    lca L(tree);
    prepare();
    int q;
    cin >> q;
    while (q--) {
        string type;
        int x, y;
        cin >> type >> x >> y;
        x--;
        y--;
        if (type[0] == 'q') {
            int l = L.query_lca(x, y);
            int bad_edges = query(l, x) + query(l, y);
            if (bad_edges > 0) cout << "Impossible"; else cout << L.distance(x, y, l);
            cout << endl;
        } else {
            if (!L.is_real_parent(x, y)) swap(x, y);
            if (!L.is_real_parent(x, y)) continue;
            if (type[0] == 'd') {
                mark(x, y, +1);
            } else {
                mark(x, y, -1);
            }
        }
    }

    return 0;
}