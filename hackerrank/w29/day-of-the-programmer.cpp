#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int y;
    cin >> y;
    bool leap = false;
    if (y < 1918) {
        leap = y%4 == 0;
    } else {
        leap = y%400==0 || (y%4==0 && y%100!=0);
    }
    if (y==1918) {
        cout << "26.09.";
    } else {
        if (leap) cout << "12.09."; else cout << "13.09.";    
    }
    
    cout << y;
    return 0;
}
