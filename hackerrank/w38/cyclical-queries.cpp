// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, int> node;
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
vl a;
vector<node> dist;

template<typename T, typename Specification>
class seg_tree {
private:
    int N;
    vector<T> a, t;

    inline void update(int v) {
        t[v] = specification::fn(t[2 * v], t[2 * v + 1]);
    }

    void build(int v, int L, int R) {
        if (L == R) {
            t[v] = a[L];
        } else {
            int mid = (L + R) >> 1;
            build(2 * v, L, mid);
            build(2 * v + 1, mid + 1, R);
            update(v);
        }
    }

    void add_val(int v, int L, int R, int pos, T delta) {
        if (L == pos && R == pos) {
            t[v] = specification::add(t[v], delta);
        } else {
            int mid = (L + R) >> 1;
            if (pos <= mid) {
                add_val(2 * v, L, mid, pos, delta);
            } else {
                add_val(2 * v + 1, mid + 1, R, pos, delta);
            }
            update(v);
        }
    }

    T query(int v, int L, int R, int l, int r) {
        if (L > R || L > r || R < l) {
            return specification::get_zero();
        }
        if (l <= L && r >= R) {
            return t[v];
        }
        int mid = (L + R) >> 1;
        T r1 = query(2 * v, L, mid, l, r);
        T r2 = query(2 * v + 1, mid + 1, R, l, r);

        return specification::fn(r1, r2);
    }

public:
    typedef Specification specification;

    void init(const vector<T> &data) {
        N = data.size();
        a.resize(N);
        copy(all(data), a.begin());
        int n = 1;
        while (n < N) {
            n <<= 1;
        }
        n <<= 1;
        t.assign(n, T());
        build(1, 0, N - 1);
    }

    T query(int l, int r) {
        return query(1, 0, N - 1, l, r);
    }

    void add_val(int pos, T delta) {
        add_val(1, 0, N - 1, pos, delta);
    }
};

struct rmq_specification {
    static inline const node &get_zero() {
        static const node IDENTITY = numeric_limits<node>::min();
        return IDENTITY;
    }

    static inline const node &fn(const node &a, const node &b) {
        return max(a, b);
    }

    static inline const node add(const node &a, const node &b) {
        return node(a.X + b.X, b.Y);
    }
};

seg_tree<node, rmq_specification> t;

void update(int v, node delta) {
    t.add_val(v, delta);
    t.add_val(v + n, delta);
}

node find_best(int x) {
    return t.query(x, x + n - 1);
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n;
    int vertex = n;
    a.assign(n, 0);
    dist.assign(2 * n, node());
    forn(i, n) cin >> a[i];
    for (int i = 1; i < 2 * n; i++) {
        dist[i].X = dist[i - 1].X + a[(i - 1) % n];
        dist[i].Y = i % n;
    }

    t.init(dist);
    vector<priority_queue<pair<ll, int>>> pq(n, priority_queue<pair<ll, int>>());

    int m;
    cin >> m;
    vi position(n + m, -1);
    forn(i, n) position[i] = i;
    while (m--) {
        int q, x, v;
        ll d;
        cin >> q >> x;
        x--;
        if (q < 3) {
            ll w;
            cin >> w;
            ll old = 0;
            if (q == 1) {
                tie(d, v) = find_best(x);
                x = position[v];
                old = pq[x].empty() ? 0 : pq[x].top().X;
                w += old;
            } else {
                old = pq[x].empty() ? 0 : pq[x].top().X;
            }
            pq[x].push({w, vertex});
            if (w >= old) update(x, node(w - old, vertex));
            position[vertex++] = x;
        } else {
            tie(d, v) = find_best(x);
            if (q == 3) {
                x = position[v];
                ll old = pq[x].top().X;
                pq[x].pop();
                ll nw = pq[x].empty() ? 0 : pq[x].top().X;
                update(x, node(nw - old, pq[x].empty() ? x : pq[x].top().Y));
            } else {
                cout << d - dist[x].X << endl;
            }
        }
    }

    return 0;
}
