#include <iostream>
#include <string>
#include <vector>
#include <stdio.h>

#define forn(i, n) for (int i=0; i<n; i++)
#define forv(i, v) for (int i=0; i<(int)(v.size()); i++)
#define pb push_back


using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        bool ok = false;
        while (n--) {
            int x;
            cin >> x;
            if (x % k == 0) {
                ok = true;
            }
        }
        if (ok) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}