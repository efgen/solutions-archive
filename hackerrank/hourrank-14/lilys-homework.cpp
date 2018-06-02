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

int f (vi a, vi b) {
    int res = 0;
    map<int, int> m;

    forv(i, a) {
        m[a[i]] = i;
    }
    forv(i, b) {
        int pos = m[b[i]];
        if (pos != i) {
            res++;
            int x = a[i];
            a[i] = a[pos];
            m[x] = pos;
        }
    }
    return res;
}

int main() {
    int n;
    vi a;
    cin >> n;
    forn(i, n) {
        int x;
        cin >> x;
        a.pb(x);
    }
    vi b(a);
    sort(all(b));
    //forv(i, b) cout << b[i] << " ";
    int res = f(a, b);
    reverse(all(b));
    res = min(res, f(a, b));
    cout << res;
    return 0;
}