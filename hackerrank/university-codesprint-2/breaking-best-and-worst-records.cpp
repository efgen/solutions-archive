#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int maxR, minR, res1 = 0, res2 = 0, n;
    cin >> n;    
    cin >> maxR;
    minR = maxR;
    for(int i=1; i<n; i++) {
        int x;
        cin >> x;
        if (x>maxR) {
            maxR = x;
            res1++;
        }
        if (x<minR) {
            minR = x;
            res2++;
        }
    }
    cout << res1 << " " << res2;
    
    return 0;
}
