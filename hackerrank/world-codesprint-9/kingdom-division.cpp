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
int mod = 1000000000 + 7;
vector<vi> a;
vl rb, br, rr, bb;

void dfs(int v, int p) {
    for (int x:a[v])
        if (x != p) {
            dfs(x, v);
            rr[v] = rr[v] * (rr[x] + br[x]) % mod;
            bb[v] = bb[v] * (rb[x] + bb[x]) % mod;

            rb[v] = rb[v] * br[x] % mod;
            br[v] = br[v] * rb[x] % mod;

        }
    rb[v] = (rr[v] - rb[v] + mod) % mod;
    br[v] = (bb[v] - br[v] + mod) % mod;
}

int main() {
    int n;
    cin >> n;
    a.assign(n, vi());
    rr.assign(n, 1);
    rb.assign(n, 1);
    bb.assign(n, 1);
    br.assign(n, 1);
    forn(i, n - 1) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }
    dfs(0, -1);
    cout << (rb[0] + br[0]) % mod;

}
