#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <sstream>
#include <cmath>
#include <ctime>
#include <bitset>

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
vector<vector<pii>> a;


void dfs(vector<set<int>> &cnt, int v, int len, int move) {
    if (len == 0) {
        cnt[v].insert(move);
        return;
    }
    move <<= 1;
    len--;
    for (auto pos:a[v]) {
        dfs(cnt, pos.first, len, move + pos.second);
    }
}

int main() {
    int n, m, d;
    cin >> n >> m >> d;
    a.assign(n, vector<pii>());
    forn(i, m) {
        int u, v, c;
        cin >> u >> v >> c;
        u--;
        v--;
        a[u].pb(mp(v, c));
        a[v].pb(mp(u, c));
    }
    vector<set<int>> cnt1(n, set<int>());
    vector<vector<set<int>>> cnt2(n, vector<set<int>>(n, set<int>()));
    dfs(cnt1, 0, (n + 1) / 2, 0);
    forn(i, n) {
        dfs(cnt2[i], i, n / 2, 0);
    }
    ll res = 0;
    forn(i, n)forn(j, n) {
            res += cnt1[i].size() * cnt2[i][j].size();
        }
    cout << res;


}