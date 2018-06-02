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
const int mod = 1000000000 + 7;
const int maxn = 201;
//     len   b    super last
int a[maxn][maxn][maxn][2];

int main() {
    a[1][1][0][1] = 1;
    for (int L = 1; L < maxn - 1; L++) {
        for (int b = 0; b <= L; b++)
            for (int d = 0; d <= L; d++)
                for (int last = 0; last < 2; last++)
                    for (int c = 0; c < 2; c++) {
                        int nb = b + (c == 0 ? -1 : 1);
                        if (nb < 0) continue;
                        int nd = d + (c == last ? 0 : 1);
                        a[L + 1][nb][nd][c] += a[L][b][d][last];
                        if (a[L + 1][nb][nd][c] >= mod) a[L + 1][nb][nd][c] -= mod;
                    }

    }

    int q;
    cin >> q;
    while (q--) {
        int n, k;
        cin >> n >> k;
        int res = 0;
        for (int i = k; i <= n; i++) {
            res += a[n][0][i][0];
            if (res >= mod) res -= mod;
        }
        cout << res << endl;
    }


}