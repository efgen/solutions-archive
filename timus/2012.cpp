#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>

#define forn(i, n) for (int i=0; i<n; i++)
#define forv(i, v) for (int i=0; i<(int)(v.size()); i++)
#define pb push_back

using namespace std;

int main() {
    int n;
    cin >> n;
    if (n < 7) cout << "NO"; else cout << "YES";
    return 0;
}