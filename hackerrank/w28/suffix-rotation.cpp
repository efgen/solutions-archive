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
    int q;
    cin >> q;
    while (q--) {
        string s;
        cin >> s;
        int res = 0;
        int n = s.length();
        forn(i, n) {
            int t = i;
            for (int j=i+1; j<n; j++) {
                if (s[j]<s[t]) {
                    t = j;
                }
            }
            if (t>i) {
                res++;
                reverse(s.begin()+i, s.begin()+t);    
                reverse(s.begin()+t, s.end());    
                reverse(s.begin()+i, s.end());    
            }

        }
        cout << res << endl;
    }
}
