package main
import "fmt"



func main() {
 //Enter your code here. Read input from STDIN. Print output to STDOUT
    var T int
    var N, K int

    usedDigits := make([]bool, 100001)
    usedPositions := make([]bool, 100001)
    
    answer := make([]int, 100001)
    
    fmt.Scanf("%d", &T)
    
    for T > 0 {
        fmt.Scanf("%d %d", &N, &K)
        
        //fmt.Printf("N=%d, K=%d \n", N, K)
        
        noAnswer := false
        
        for i:=1; i<=N; i++ {
            usedDigits[i] = false
            usedPositions[i] = false
            answer[i] = 0
        }
        
        for i:=1; i<=K; i++ {
            
            if i+K > N {
                noAnswer = true
                break
            }
            
            usedDigits[i+K] = true
            usedPositions[i] = true
            answer[i] = i+K
        }
               
        for i:=N; i>N-K; i-- {
       
            if i-K < 1 {
                noAnswer = true
                break
            }
            
            if usedDigits[i-K] || usedPositions[i] {
                noAnswer = true
                break
            }
            
            usedDigits[i-K] = true
            usedPositions[i] = true
            answer[i] = i-K
        }
        
        
        
        for i:=K+1; i<=N-K; i++ {
            if usedDigits[i-K] {
                if usedDigits[i+K] {
                    noAnswer = true
                    break
                } else {
                    answer[i] = i+K
                    usedDigits[i+K] = true
                }
            } else {
                answer[i] = i-K
                usedDigits[i-K] = true
            }
        }
        
        if noAnswer {
            fmt.Println(-1)
        } else {
            for i:=1; i<=N; i++ {
                fmt.Printf("%d ", answer[i])
            }
            fmt.Printf("\n")
        }
        
        T--
    }
    
    
}