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

map<int, double> mem[32];

inline int del(int t, int k) {
    return (t >> (k+1) << k) | (t&((1<<k)-1));
}

double f(int n, int k, int t) {
    if (mem[n].count(t)) return mem[n][t];

    if (k==0 || t==0) return 0;
    double res = 0;
    for(int i=n/2-1; i>=0; --i) {
        int j = n-i-1;
        res += max((t&(1<<i)?1:0)+f(n-1, k-1, del(t, i)), (t&(1<<j)?1:0) + f(n-1, k-1, del(t, j)));
    }
    res *= 2;
    if (n&1) {
        int i = n/2;
        res += (t&(1<<i)?1:0) + f(n-1, k-1, del(t, i));
    }    
    return mem[n][t] = res/n;
}

int main() {
    int n, k;
    string s;
    cin >> n >> k >> s;
    int t = 0;
    forn(i, n) {
        t <<= 1;
        t += s[i]=='W' ? 1 : 0; 
    }
    printf("%0.9lf", f(n, k, t));
}
