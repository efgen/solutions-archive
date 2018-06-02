package main
import "fmt"


func main() {
    
    var N int // the number of digits in the number
    var K int // the maximum number of digits that can be altered
    
    fmt.Scanf("%d %d", &N, &K)
    
    S := make([]int, N)
    for key, _ := range S {
        fmt.Scanf("%c", &S[key])
        S[key] -= '0'
    }
    
    var i, j, z int
    j = N-1
    
    for i < j {
        if S[i] != S[j] {
            z++
        }
        i++
        j--
    }
    
    //fmt.Printf("S=%+v \n", S)
    
    if z > K {
        fmt.Println(-1)      
    } else {
        K = K - z
        
        i=0
        j=N-1
        for i < j {
            if S[i] != S[j] {
                
                if S[i] > S[j] {
                    S[j] = S[i]
                    z--
                } else {
                    S[i] = S[j] 
                    z--
                }   
                if K > 0 && S[i] < 9 {
                    S[i]=9
                    S[j]=9
                    K--
                } 
            } else {
                 if K > 1 && S[i] < 9 {
                    S[i]=9
                    S[j]=9
                    K -= 2
                } 
            }
         
            i++
            j--
        }
          
        if i == j && K > 0 {
            S[i] = 9
        }

        for _, s := range S {
            fmt.Printf("%d", s)
        }
    
    }
  
    
   // fmt.Printf("AFTER : S=%+v \n", S)
    
}