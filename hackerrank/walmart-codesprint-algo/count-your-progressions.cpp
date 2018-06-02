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
const int mod = 1000000009;

int main() {
    int n;
    vi a;
    scanf("%d", &n);
    int min = mod, max = -mod;
    forn(i, n) {
        int x;
        scanf("%d", &x);
        a.pb(x);
        if (x < min) {
            min = x;
        }
        if (x > max) {
            max = x;
        }
    }
    ll ans = 0;
    for (int d = min - max; d <= max - min; d++) {
        vl dp(max + 1);
        ll res = 0;
        for (int i = n - 1; i >= 0; --i) {
            int next = a[i] + d;
            dp[a[i]] += ((next >= min && next <= max) ? dp[next] : 0) + 1;
            dp[a[i]] %= mod;

        }
        for (ll x:dp) {
            res += x;
            res %= mod;
        }
        ans += res - n;
        ans = (mod + ans % mod) % mod;
    }
    ans = (ans + n + 1) % mod;
    cout << ans;
    return 0;
}