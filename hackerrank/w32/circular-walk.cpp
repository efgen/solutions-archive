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
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, s, t, g, seed, p;
    cin >> n >> s >> t;
    vi step(n);
    cin >> step[0] >> g >> seed >> p;
    for(int i=1; i<n; i++) {
        step[i] =  (int)(((ll)step[i-1]*g+seed)%p);      
    }
    int l1 = s+n, t1 = s+n;
    int l0 = l1+1, t0 = t1;
    bool ok = false;
    int steps = 0;    
    while (t0-l0<n) {     
        
        if (l1<=t && t<=t1 || l1<=t+n && t+n<=t1 || l1<=t+2*n && t+2*n<=t1) {
            ok = true;
            break;
        }
        steps++;
        int l2 = l1, t2 = t1;
        for(int x = l1; x<l0; x++) {
            int d = step[x%n];
            l2 = min(l2, x-d);
            t2 = max(t2, x+d);
        }
        for(int x = t0+1; x<=t1; x++) {
            int d = step[x%n];
            l2 = min(l2, x-d);
            t2 = max(t2, x+d);
        }
        if (l2==l1 && t2==t1) break;
        l0 = l1; t0 = t1;
        l1 = l2; t1 = t2;
    }
    if (!ok) steps = -1;
    cout << steps;      
    
}
