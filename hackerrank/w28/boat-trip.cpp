#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n,m,c,p,pm;
    cin >> n >> c >> m;
    pm = -1;
    for (int i=0; i<n; i++) {
        cin >> p;
        if (p>pm) pm = p;
    }
    if (pm<=c*m) cout << "Yes"; else cout << "No";
    return 0;
}
