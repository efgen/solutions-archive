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


int main() {
    set<int> good;
    string s;
    int n;
    cin >> s >> n;
    char old = -1;
    int r = 0;
    for (char c:s) {
        c -= 'a' - 1;
        if (c == old) {
            r += c;
        } else {
            r = c;
            old = c;
        }
        good.insert(r);
    }
    while (n--) {
        int k;
        cin >> k;
        if (good.count(k)) cout << "Yes"; else cout << "No";
        cout << endl;
    }
}
