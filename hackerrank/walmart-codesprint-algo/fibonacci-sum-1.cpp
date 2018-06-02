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
#define mod (1000000000 + 7)


void multiply(int F[2][2], int M[2][2]);

void power(int F[2][2], int n);

pair<int, pii> fib(int n) {
    int F[2][2] = {{1, 1},
                   {1, 0}};
    if (n == 0)
        return mp(-1, mp(0, 1));
    power(F, n);
    return mp(F[1][1], mp(F[0][1], F[0][0]));
}

void power(int F[2][2], int n) {
    if (n == 0 || n == 1)
        return;
    int M[2][2] = {{1, 1},
                   {1, 0}};

    power(F, n / 2);
    multiply(F, F);

    if (n % 2 != 0)
        multiply(F, M);
}

void multiply(int F[2][2], int M[2][2]) {
    ll x = (ll) F[0][0] * M[0][0] + (ll) F[0][1] * M[1][0];
    ll y = (ll) F[0][0] * M[0][1] + (ll) F[0][1] * M[1][1];
    ll z = (ll) F[1][0] * M[0][0] + (ll) F[1][1] * M[1][0];
    ll w = (ll) F[1][0] * M[0][1] + (ll) F[1][1] * M[1][1];

    F[0][0] = x % mod;
    F[0][1] = y % mod;
    F[1][0] = z % mod;
    F[1][1] = w % mod;
}

int main() {
    int q;
    cin >> q;
    while (q--) {
        int n;
        cin >> n;
        vi a;
        forn(i, n) {
            int x;
            cin >> x;
            a.pb(x);
        }
        ll res = 0;
        pair<int, pii> last = fib(a[n - 1]);
        ll fs = last.second.first;
        ll fs_1 = last.first;
        res = fs;
        for (int i = n - 2; i >= 0; --i) {
            pair<int, pii> cur = fib(a[i]);

            ll nfs = (ll) cur.second.second * fs + (ll) cur.second.first * (fs_1 + 1);
            ll nfs_1 = (ll) cur.second.first * fs + (ll) cur.first * (fs_1 + 1);
            fs = nfs % mod;
            fs_1 = nfs_1 % mod;

            res += fs;
            res %= mod;
        }
        cout << res << endl;

    }
    return 0;
}