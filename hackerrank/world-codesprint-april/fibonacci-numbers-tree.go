package main
import "fmt"

var N, M int
var Parent []int
var Numbers [][]int64
var SomeMatrix [][]int
var Labels = make(map[int]bool, 0)
var modulo = int64(1000000007)

func Multiple(A, B [][]int) (C [][]int) {
    var res int64
    C = make([][]int, 3)
    
    for i:=0; i<3; i++ {
        C[i] = make([]int,3)
        for j:=0; j<3; j++ {
            res = 0
            for k:=0; k<3; k++ {
                res += int64(A[i][k]) * int64(B[k][j])
            }
            
            C[i][j] = int(res % modulo)
        }
    }
    
    return
}

func Power(A [][]int, N int64) [][]int {
    B := make([][]int, 3)
    
    res := make([][]int, 3)
    res[0] = []int{1, 0, 0}
    res[1] = []int{0, 1, 0}
    res[2] = []int{0, 0, 1}
    
    fmt.Printf("N: %+v \n", N)
    
    for i:=0; i<3; i++ {
        for j:=0; j<3; j++ {
            B[i] = append(B[i], A[i][j])
        }
    }
    
    for N>0 {
        if N % 2 == 1 {
            res = Multiple(res, B)
        }
        B = Multiple(B, B)
        N = N/2
    }
    fmt.Printf("MATRIX: %+v \n", res)
    
    return res
}

func GetSK(k int64) int64 {
    if k == 0 {
        return 0
    }
    r := Power(SomeMatrix, k)
    fmt.Println(k, r[0][0])
    return int64(r[0][0])
}

func GoUpTo(v int) int64 {
    var l int64
    var res int64
    
    for v >= 0 {
        Labels[v] = true
        
        for _, FK := range Numbers[v] {
            res += GetSK(FK+l) - GetSK(FK-1)
        }
        v = Parent[v]
    }
    return (res % modulo + modulo) % modulo
}

func GoUpTo2(v int) (int64, int) {
    var l int64
    var res int64
    
    firstV:= -1
    
    for v >= 0 {
        if _, ok := Labels[v]; ok && firstV < 0 {
            firstV = v
        }
        
        for _, FK := range Numbers[v] {
            res += GetSK(FK+l) - GetSK(FK-1)
        }
        v = Parent[v]
    }
    return Norm(res), firstV
}

func Norm(x int64) int64 {
    return (x % modulo + modulo) % modulo
}

func main() {
 //Enter your code here. Read input from STDIN. Print output to STDOUT
    
    fmt.Scanf("%d%d", &N, &M)
    
    Parent = make([]int, N)
    Numbers = make([][]int64, N)
    
    SomeMatrix = make([][]int, 3)
    SomeMatrix[0] = []int{1, 1, 1}
    SomeMatrix[1] = []int{0, 1, 1}
    SomeMatrix[2] = []int{0, 1, 0}
    
   // fmt.Printf("%+v \n", SomeMatrix)
    
    Parent[0] = -1
    
    // read labels
    for i:=1; i<N; i++ {
        fmt.Scanf("%d", &Parent[i])
        Parent[i]--
    }
    
    var operation rune
    var X int
    var KorY int64
    for i:=0; i<M; i++ {
        fmt.Scanf("%c %d %d", &operation, &X, &KorY)
        X--
       
        
        if operation == 85 {
            k := KorY
            Numbers[X] = append(Numbers[X], k)
        } else {
            Labels = make(map[int]bool, 0)
            
            Y := int(KorY) - 1
            res1 := GoUpTo(X)
            res2, lca := GoUpTo2(Y)
            res3 := GoUpTo(lca)
            
            fmt.Println(X, Y, lca, res1, res2, res3)
            
            //fmt.Println(Norm(res1 + res2 - res3))
        }
        
      //  fmt.Println(operation, X, KorY)
    }
    
   // fmt.Printf("Numbers: %+v\n", Numbers)
}