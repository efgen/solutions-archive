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
vi h, p;
unordered_map<ll, ll> mem;

ll go(int k, int H) {
    if (k >= n) return 0;
    ll key = k * 1000000007L + H;
    if (mem.count(key)) return mem[key];
    if (h[k] > H) return mem[key] = h[k] - H + p[k] + go(k + 1, h[k]);
    if (p[k] > 0) return mem[key] = go(k + 1, H);
    return mem[key] = min(go(k + 1, H), go(k + 1, h[k]) + abs(h[k] - H) + p[k]);
}

const ll inf = 1l << 60;

struct min_seg_tree {
    vl a;
    vl t;

    void init(const vl &data) {
        int N = data.size();
        a.assign(N, 0);
        forn(i, N) a[i] = data[i];
        int n = 1;
        while (n <= N) {
            n <<= 1;
        }
        n <<= 1;
        t.assign(n, 0);
    }

    void update(int v) {
        t[v] = min(t[2 * v], t[2 * v + 1]);
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

    void set_val(int v, int L, int R, int pos, ll val) {
        if (L == pos && R == pos) {
            t[v] = val;
        } else {
            int mid = (L + R) >> 1;
            if (pos <= mid) {
                set_val(2 * v, L, mid, pos, val);
            } else {
                set_val(2 * v + 1, mid + 1, R, pos, val);
            }
            update(v);
        }
    }

    ll query_min(int v, int L, int R, int l, int r) {
        if (L > R || L > r || R < l) {
            return inf;
        }
        if (l <= L && r >= R) {
            return t[v];
        }
        int mid = (L + R) >> 1;
        auto r1 = query_min(2 * v, L, mid, l, r);
        auto r2 = query_min(2 * v + 1, mid + 1, R, l, r);
        return min(r1, r2);
    }
};

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n;
    h.assign(n, 0);
    p.assign(n, 0);
//    mem.reserve(n * 20);
    forn(i, n) cin >> h[i];
    forn(i, n - 1) cin >> p[i + 1];


    stack<int> better;
    vi right_max(n);
    for (int i = n - 1; i >= 0; --i) {
        while (!better.empty() && h[better.top()] <= h[i]) {
            better.pop();
        }
        right_max[i] = better.empty() ? n : better.top();
        better.push(i);
    }

    vl r(n, inf);
    min_seg_tree t;
    t.init(r);
    t.build(1, 0, n - 1);

    r[n - 1] = p[n - 1];
    t.set_val(1, 0, n - 1, n - 1, p[n - 1] - h[n - 1]);

//    cout <<  t.query_min(1, 0, n - 1, 0, n - 1) << endl;

    for (int i = n - 2; i >= 0; --i) {
        int pos = right_max[i];
        ll res = t.query_min(1, 0, n - 1, i + 1, pos - 1);
        res += h[i];
        if (pos < n) res = min(res, h[pos] - h[i] + r[pos]);
        else {
            if (res > 0) res = 0;
        }
        res += p[i];
        r[i] = res;
        t.set_val(1, 0, n - 1, i, res - h[i]);
    }


//    ll r1 = n + go(1, h[0]);
    ll r2 = r[0] + n;
//    assert(r1 <= r2);
    cout << r2;

    return 0;
}
