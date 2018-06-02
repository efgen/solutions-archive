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

inline int cmp(int a, int b) {
    if (a == b) return 0; else if (a < b) return 1; else return 2;
}

ll calc(ll N) {
    ll initialN = N;
    // if (N < 100) return 0;
    vi digits;
    while (N > 0) {
        digits.pb((int) (N % 10));
        N /= 10;
    }
    reverse(all(digits));

    ll res = 0;
    ll a[10][3][2][2];
    ll b[10][3][2][2];
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
    a[0][0][1][1] = 1;

    forv(i, digits) {
        int curDigit = digits[i];
        forn(d, 10) {
            forn(state, 3) {
                forn(isprefix, 2) {
                    forn(firstDigit, 2) {
                        int newPrefix = 0;
                        ll lastAns = a[d][state][isprefix][firstDigit];
                        if (lastAns == 0) continue;
                        forn (c, 10) {
                            if (isprefix) {
                                if (c > curDigit) continue;
                                if (c == curDigit) newPrefix = 1;
                            }
                            int newState = cmp(d, c);
                            if (firstDigit) newState = 0;
                            b[c][newState][newPrefix][firstDigit && c == 0] +=
                                    lastAns + ((state + newState == 3) ? 1 : 0);
                        }
                    }
                }
            }
        }
        res = 0;
        forn(d, 10) {
            forn(state, 3) {
                forn(isprefix, 2) {
                    forn(firstDigit, 2) {
                        a[d][state][isprefix][firstDigit] = b[d][state][isprefix][firstDigit];
                        res += a[d][state][isprefix][firstDigit];
                        b[d][state][isprefix][firstDigit] = 0;
                    }
                }
            }
        }

    }
    return res - initialN;
}

int main() {
//    cout << calc(99);
    ll A, B;
    cin >> A >> B;
    cout << calc(B) - calc(A - 1);
    return 0;
}