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

vector<vi> g;
bool f[100000];

int dfs(int v) {
    int res = 1;
    f[v] = true;
    for (int x:g[v])
        if (!f[x]) 
            res += dfs(x);
    return res;    
}

int main() {
    int q;
    cin >> q;
    while (q--) {
        int n,m;
        cin >> n >> m;
        vector<vi> gg(n, vi(0));
        g = gg;
        forn(i, m) {
            int x, y;
            cin >> x >> y;
            x--; y--;
            g[x].pb(y);
            g[y].pb(x);
        }
        forn(i, n) f[i] = false;
        vi cnts;
        forn(i, n) 
            if (!f[i])
                cnts.pb(dfs(i));
        ll total = 0, cur = 0, other = 0;
        sort(all(cnts));
        reverse(all(cnts));    
        //for (int x:cnts) cout << x << " ";
        for (int x:cnts) {
            cur = 0;
            forn(k, x-1) {               
                cur = ((ll)(k+1))*(k+2);
                total += other + cur;
            }
            other += cur;
            m -= x-1;
        }
        total += m * other;
        cout << total << endl;
    }




}


