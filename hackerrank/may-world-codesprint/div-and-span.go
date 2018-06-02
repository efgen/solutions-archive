package main
import (
    "fmt"
)

var (
    modulo = int64(1000000007)
    N = 100000
    F = make([]int64, N+1)
    K = make([]int64, N+1)
    
    M = 200
    D = make([][]int64, M+1)
    DS = make([][]int64, M+1)
)

func Power(a int64, n int64) (result int64) {
    result = 1
    
    for n > 0 {
        if n & 1 == 1 {
            result = result * a % modulo
        }
        a = a*a % modulo
        n = n>>1
    }
    return
}
    
func Inv(n int) int64 {
    return Power(int64(n), modulo-2)
}

func Min(x, y int32) (min int32) {
    min = y
    if x < y {
        min=x
    }
    return
}

func main() {
    // factorial and catalan
    F[0] = 1
    K[0] = 1
    
    for n:=1; n<=N; n++ {
        F[n] = int64(n) * F[n-1] % modulo
        K[n] = ((2 * (2*int64(n) - 1) * K[n-1]) % modulo) * Inv(n+1) % modulo
    }

    //fmt.Printf("F=%+v \n", F)
   // fmt.Printf("K=%+v \n", K)
    
    for i:=0; i<=M; i++ {
        D[i] = make([]int64, M+1)
        DS[i] = make([]int64, M+1)
    }
    
    D[0][0] = 1
    D[1][1] = 1
    
    for m:=2; m<=M; m++ {
        for k:=1; k<=m; k++ {
            
            var result int64
            
            //fmt.Printf("k=%d)
            for z:=1; z<=m; z++ {
                //fmt.Printf(" IF %d-1 >= 1 and %d-1 <= %d-%d OR %d-1 == 0 and %d-%d == 0 \n", k, k, m, z, k, m, z)
                if (((k-1) >= 1) && ((k-1) <= (m-z))) || (k-1 == 0 && (m-z) == 0) {
                    //fmt.Printf("m=%d k=%d z=%d  result=%d+K[%d-1]*D[%d-%d][%d-1]\n", m, k, z, result, z, m, z, k)
                    result += K[z] * D[m-z][k-1] % modulo
                }
            }
            
            D[m][k] = result % modulo
            //fmt.Printf("D[%d][%d]=%d \n\n", m, k, result)
        }
    }
    
    for m:=0; m<=M; m++ {
        for k:=1; k<=m; k++ {
            
            var result int64
            
            for g:=k; g<=m; g++ {
                result += D[m][g]
                
            }
            DS[m][k] = result % modulo
            //fmt.Printf("D[%d][%d]=%d \n\n", m, k, result)
        }
    }
    
    //fmt.Printf("D: %+v \n", D)
    
    var T int
    fmt.Scanf("%d", &T)
    
    var m, n int32
    // n - square brackets - 10^5
    // m - parentheses - 200
    for i:=0; i<T; i++ {
        fmt.Scanf("%d %d", &n, &m)
        //fmt.Printf("n=%d m=%d \n", n, m)
        
        
        border := Min(2*n+1, m)
        var C, result int64
        C = 1

        var g int32    
        for g=1; g <= border; g++ {
            //fmt.Printf("g=%d 2*n+1=%d ", g, 2*n+1)
            
            C = C * (2*int64(n) + 2 - int64(g)) % modulo
            C = C * Inv(int(g)) % modulo
            
            //fmt.Printf("C=%d   -> result=result+C*D[%d][%d]=%d+C*%d= \n", C, m, g, result, D[m][g])
            
            result += C * D[m][g] % modulo
        }
        result = result % modulo
        //fmt.Printf("result=%d \n\n", result)
        result = result * K[n] % modulo
        
        result = result * F[n] % modulo
        result = result * F[m] % modulo
        
        fmt.Println(result)
    }
    

    
}