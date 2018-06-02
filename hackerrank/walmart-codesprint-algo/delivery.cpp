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

int dist(int x, int y) {
    int res = 0;
    while (x != y) {
        if (x > y) swap(x, y);
        y >>= 1;
        res++;
    }
    return res;
}

int main() {
    int n, m, q;
    cin >> n >> m >> q;
    vvi food(m);
    forn(i, m) {
        int k;
        cin >> k;
        while (k--) {
            int x;
            cin >> x;
            food[i].pb(x);
        }
    }
    int p = 1;
    ll res = 0;
    while (q-- > 0) {
        int ft, dst;
        cin >> ft >> dst;
        ft--;
        int min = 1 << 30;
        for (auto x:food[ft]) {
            int d = dist(p, x) + dist(x, dst);
            if (d < min) {
                min = d;
            }
        }
        p = dst;
        res += min;

    }
    cout << res;
    return 0;
}