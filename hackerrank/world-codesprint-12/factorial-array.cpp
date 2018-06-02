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
const int mod = 1000000000;
const int max_sz = 40;
static vl ff(50, 0);

struct factorials {
    int cnt[max_sz];

    void shift(int delta) {
        if (delta < max_sz) {
            for (int i = max_sz - 1; i >= delta; i--) {
                cnt[i] = cnt[i - delta];
            }
            forn(i, delta) cnt[i] = 0;
        } else {
            forn(i, max_sz) cnt[i] = 0;
        }
    }

    void merge(const factorials &v1, const factorials &v2) {
        forn(i, max_sz) cnt[i] = v1.cnt[i] + v2.cnt[i];
    }

    void set_val(int val) {
        forn(i, max_sz) cnt[i] = 0;
        if (val < max_sz) {
            cnt[val] = 1;
        }
    }

    int get_val() {
        ll res = 0;
        forn(i, max_sz) {
            res += cnt[i] * ff[i] % mod;
        }
        return (int) (res % mod);
    }
};

struct factorial_seg_tree {
    vi a, lazy;
    vector<factorials> c;

    void init(const vi &data) {
        int N = data.size();
        a.assign(N, 0);
        forn(i, N) a[i] = data[i];
        int n = 1;
        while (n <= N) {
            n <<= 1;
        }
        n <<= 1;
        c.assign(n, factorials());
        lazy.assign(n, 0);
    }

    void update(int v) {
        c[v].merge(c[2 * v], c[2 * v + 1]);
    }

    void build(int v, int L, int R) {
        if (L == R) {
            c[v].set_val(a[L]);
        } else {
            int mid = (L + R) >> 1;
            build(2 * v, L, mid);
            build(2 * v + 1, mid + 1, R);
            update(v);
        }
    }

    void push(int v, int L, int R) {
        if (lazy[v] != 0) {
            c[v].shift(lazy[v]);
            if (L != R) {
                lazy[2 * v] += lazy[v];
                lazy[2 * v + 1] += lazy[v];
            }
            lazy[v] = 0;
        }
    }

    void range_add(int v, int L, int R, int l, int r, int add) {
        push(v, L, R);
        if (L > R || L > r || R < l) {
            return;
        }
        if (l <= L && r >= R) {
            lazy[v] += add;
            push(v, L, R);
        } else {
            int mid = (L + R) >> 1;
            range_add(2 * v, L, mid, l, r, add);
            range_add(2 * v + 1, mid + 1, R, l, r, add);
            update(v);
        }
    }

    void set_val(int v, int L, int R, int pos, int val) {
        push(v, L, R);
        if (L == pos && R == pos) {
            c[v].set_val(val);
        } else {
            int mid = (L + R) >> 1;
            if (pos <= mid) {
                set_val(2 * v, L, mid, pos, val);
                push(2 * v + 1, mid + 1, R);
            } else {
                set_val(2 * v + 1, mid + 1, R, pos, val);
                push(2 * v, L, mid);
            }
            update(v);
        }
    }

    int query_sum(int v, int L, int R, int l, int r) {
        if (L > R || L > r || R < l) {
            return 0;
        }
        push(v, L, R);
        if (l <= L && r >= R) {
            return c[v].get_val();
        }
        int mid = (L + R) >> 1;
        auto r1 = query_sum(2 * v, L, mid, l, r);
        auto r2 = query_sum(2 * v + 1, mid + 1, R, l, r);
        return (r1 + r2) % mod;
    }
};

factorial_seg_tree F;

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ff[0] = 1;
    for (int i = 1; i < max_sz; i++) {
        ff[i] = i * ff[i - 1] % mod;
    }

    int n, m;
    cin >> n >> m;
    vi data(n, 0);
    forn(i, n) cin >> data[i];
    F.init(data);
    F.build(1, 0, n - 1);

    while (m--) {
        int op, l, r;
        cin >> op;
        if (op == 1) {
            cin >> l >> r;
            F.range_add(1, 0, n - 1, l - 1, r - 1, 1);
        }
        if (op == 2) {
            cin >> l >> r;
            cout << F.query_sum(1, 0, n - 1, l - 1, r - 1) << endl;
        }
        if (op == 3) {
            int pos, val;
            cin >> pos >> val;
            F.set_val(1, 0, n - 1, pos - 1, val);
        }
    }

    return 0;
}
