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

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back

vector<vi> a;
int n;
vi order;
vi first, last;

void dfs(int v, int p) {
    first[v] = order.size();
    order.pb(v);
    for (int x:a[v])
        if (x != p) {
            dfs(x, v);
        }
    last[v] = order.size();
}

int main() {
    int q;
    cin >> q;
    while (q--) {
        cin >> n;
        a.assign(n, vi());
        forn(i, n - 1) {
            int x, y;
            cin >> x >> y;
            x--;
            y--;
            a[x].pb(y);
            a[y].pb(x);
        }
        last.assign(n, 0);
        first.assign(n, 0);
        order.clear();
        dfs(0, -1);
        vi cnt(n + 1, 0);
        int g, k;
        cin >> g >> k;
        forn(i, g) {
            int x, y;
            cin >> x >> y;
            x--;
            y--;
            if (first[x] < first[y]) {
                cnt[0]++;
                cnt[first[y]]--;
                cnt[last[y]]++;
                cnt[n]--;
            } else {
                cnt[first[x]]++;
                cnt[last[x]]--;
            }
        }
        int res = 0;
        int t = 0;
        forn(i, n + 1) {
            t += cnt[i];
            if (t >= k) res++;
        }
        assert(t == 0);
        int d = __gcd(res, n);
        res /= d;
        n /= d;
        cout << res << "/" << n << endl;
    }

}
