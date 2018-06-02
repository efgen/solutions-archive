package main
import "fmt"

var N, M int
var A = make([]int, 0) 
var T []int

var Cache = make(map[int]int64, 0)

func Solve(L int, R int) int64 {
    if (L > R) {
        return 0
    }
     
    
 
    cashKey := L*N+R
    if v, ok := Cache[cashKey]; ok {
        return v
    }

  
    
    //max := L
    var res int64
    
   /* for i:=L; i<=R; i++ {
        if (A[i] > A[max]) {
            max = i
        }    
    }*/
    max := GetMax(1, 1, N, L, R)
    res = int64(max-L+1)*int64(R-max+1)*int64(A[max])
    res += Solve(L, max - 1) + Solve(max + 1, R)
    
   
     Cache[cashKey] = res

    
    return res
}

func Build(v int, tl int, tr int) {
	if (tl == tr) {
		T[v] = tl
    } else {
        tm := (tl + tr) / 2
		Build(v*2, tl, tm)
		Build(v*2+1, tm+1, tr)
		T[v] = T[v*2]
        if (A[T[v*2+1]] > A[T[v*2]]) {
            T[v] = T[v*2+1]
        }
       
	}
   
}


func Max(a, b int) int {
    if (a>b) {
        return a
    } else {
        return b
    }
}

func Min(a, b int) int {
    if (a<b) {
        return a
    } else {
        return b
    }
}

func GetMax(v, tl, tr, l, r int) int{
    //  fmt.Println(v, tl, tr, l, r);
	if (l > r) {
		return -1
    }
	if (l == tl && r == tr){
        return T[v]
    }		
    tm := (tl + tr) / 2
    p1 := GetMax(v*2, tl, tm, l, Min(r, tm))
    p2 := GetMax(v*2+1, tm+1, tr, Max(l, tm+1), r)
    if p1 < 0 {
        return p2
    }
    if p2 < 0 {
        return p1
    }
	if A[p1] > A[p2] {
        return p1
    } else {
        return p2
    }
		
}

func main() {
    fmt.Scanf("%d %d", &N, &M)
    A = make([]int, N+1) 
    var x int
    for i:=1; i<=N; i++ {
        fmt.Scanf("%d", &x)
        A[i] = x
    }
    T = make([]int, 4*N) 
    Build(1, 1, N)
   // fmt.Printf("%+v", T)
    
    var L, R int
    for M > 0 {
        fmt.Scanf("%d %d", &L, &R)            
        fmt.Println(Solve(L, R))
        //fmt.Println(GetMax(1, 1, N, L, R))
        M--
    }
    
}