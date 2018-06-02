#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <set>

#define forn(i, n) for (int i=0; i<n; i++)
#define forv(i, v) for (int i=0; i<(int)(v.size()); i++)
#define pb push_back

using namespace std;
const int maxn = 10000;
int values[maxn];

int gr(int n) {
    set<int> t;
    for (int x = 1; x < n; x += 2) {
        for (int y = 1; y < n; y += 2) {
            int z = n - x - y;
            if (z <= 0) continue;
            t.insert(values[x] ^ values[y] ^ values[z]);
        }
    }
    for (int v = 0; v <= n; v++)
        if (!t.count(v)) {
            values[n] = v;
            return v;
        }
    return -1;
}


int fastGr(int n) {
    if (n % 4 == 1) return 0;
    return 1;
}

int main() {
    int n;
    cin >> n;
    int res = 0;
    while (n--) {
        int x;
        cin >> x;
        res ^= fastGr(x);
    }
    if (res) cout << "Daenerys"; else cout << "Stannis";
    return 0;
}