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
const int maxn = 100000;
vi a[maxn];
int val[maxn];
bool f[maxn];
int newVal;
int type;

void dfs(int v) {
    f[v] = true;
    if (type == 1) val[v] = newVal;
    else if (val[v] > newVal) {
        val[v] = newVal;
    }
    forv(i, a[v]) {
        if (!f[a[v][i]]) {
            dfs(a[v][i]);
        }
    }
}

int main() {
    int n, m, q;
    scanf("%d%d%d", &n, &m, &q);
    forn(i, m) {
        int x, y;
        scanf("%d%d", &x, &y);
        x--;
        y--;
        a[x].pb(y);
    }
    while (q--) {
        scanf("%d", &type);
        if (type == 1 || type == 2) {
            int u, x;
            scanf("%d%d", &u, &newVal);
            u--;
            memset(f, 0, sizeof f);
            dfs(u);
        } else {
            int v;
            scanf("%d", &v);
            v--;
            cout << val[v] << endl;
        }
    }

}