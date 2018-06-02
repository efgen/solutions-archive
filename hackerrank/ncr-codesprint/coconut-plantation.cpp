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
vector<vector<int>> t;
int r, c;

int sum(int x, int y) {
    int result = 0;
    for (int i = x; i >= 0; i = (i & (i + 1)) - 1)
        for (int j = y; j >= 0; j = (j & (j + 1)) - 1)
            result += t[i][j];
    return result;
}

void inc(int x, int y, int delta) {
    for (int i = x; i <= r; i = (i | (i + 1)))
        for (int j = y; j <= c; j = (j | (j + 1)))
            t[i][j] += delta;
}

int main() {
    int q;
    scanf("%d", &q);
    while (q--) {
        int n, m;
        scanf("%d%d%d%d", &r, &c, &n, &m);
        t.assign(r + 1, vector<int>(c + 1));
        vector<vector<bool>> a(r + 2, vector<bool>(c + 2));
        vector<vector<int>> cntU(r + 2, vector<int>(c + 2));
        vector<vector<int>> cntL(r + 2, vector<int>(c + 2));
        vector<bool> lineUp(c + 1);
        vector<bool> lineLeft(r + 1);
        forn(i, n) {
            int x1, y1, x2, y2;
            scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
            x2++;
            y2++;
            inc(x1, y1, 1);
            inc(x2, y1, -1);
            inc(x1, y2, -1);
            inc(x2, y2, 1);
        }
        forn(i, r) {
            forn(j, c) {
                a[i + 1][j + 1] = sum(i, j) >= m;
                //cout << a[i + 1][j + 1] << " ";
            }
            //cout << endl;
        }
        forn(i, r + 1) {
            forn(j, c + 1) {
                if (a[i][j]) {
                    cntU[i][j] = cntU[i - 1][j] + 1;
                    cntL[i][j] = cntL[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = r; i > 0; --i) {
            for (int j = c; j > 0; --j) {
                if (a[i][j] && !(lineUp[j] || lineLeft[i])) {
                    //cout << i << " " << j << endl;
                    res++;
                    if (cntL[i][j] >= cntU[i][j]) {
                        lineLeft[i] = true;
                    } else {
                        lineUp[j] = true;
                    }
                }
                if (!a[i][j]) {
                    lineLeft[i] = false;
                    lineUp[j] = false;
                }
            }
        }
        cout << res << endl;
    }
}
