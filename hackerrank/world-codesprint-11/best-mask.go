package main

import (
	"fmt"
)

var ar = [27][100000]int{}

func cnt(x int) int {
    res := 0
    for x>0 {
        x &= x - 1
        res++
    }
    return res
}

func cmp(a int, b int) bool{
    t := cnt(a) - cnt(b)
    if (t == 0) {
        return a < b
    } else {
        return t < 0 
    }
}


func solve(sz int, step int) int {
    a := &ar[step];
    //fmt.Println(a);
    a2 := &ar[step+1]
    nsz := 0
    for i:=0; i<sz; i++ {
        if (a[i]&1)==0 {
            a2[nsz] = a[i] >> 1
            nsz++
        }
    }
    if nsz == 0 {
        return 1
    }
    msk1 := solve(nsz, step+1)<<1 + 1
    for i:=0; i<sz; i++ {
        if (a[i]&1)!=0 {
            a2[nsz] = a[i] >> 1
            nsz++;
            if a[i] == 1 {
                return msk1
            }
        }
    }   
    msk2 := solve(nsz, step+1)<<1
    if cmp(msk1, msk2) {
        return msk1
    } else {
        return msk2
    }
}

func main() {
	var n int
	fmt.Scanf("%d\n", &n)
	for i := 0; i < n; i++ {
        fmt.Scanf("%d", &ar[0][i])

	}
    fmt.Print(solve(n, 0));
}
