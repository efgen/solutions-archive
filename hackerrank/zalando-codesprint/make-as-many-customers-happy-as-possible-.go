package main
import (
    "fmt"
    "strings"
)

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func main() {
    var Na, Nb, Nc int
    fmt.Scanf("%d %d %d", &Na, &Nb, &Nc)
    
    var M int
    fmt.Scanf("%d", &M)

    var str string
    
    var a, b, c, ab, bc, ac, abc int
    
    for M>0 {
        M--
        fmt.Scanf("%s", &str)
        needs := strings.Split(str, ",")
        
        items := make(map[string]bool)
        for _, v := range needs {
            items[v] = true
        }
        
        //fmt.Printf("needs: %+v \n", needs)
        l := len(needs)
        if l == 1 {
            if needs[0] == "A" {
                a++
            }
            if needs[0] == "B" {
                b++
            }
            if needs[0] == "C" {
                c++
            }
        }
        

        if l == 2 {
            if _, ok := items["A"]; !ok {
                bc++
            }
            if _, ok := items["B"]; !ok {
                ac++
            }
            if _, ok := items["C"]; !ok {
                ab++
            }
        }
        
        if l == 3 {
            abc++
        }
    }
    
    res := 0
    k := Min(Na, a)
    Na -= k
    res += k
    
    k = Min(Nb, b)
    Nb -= k
    res += k
    
    k = Min(Nc, c)
    Nc -= k
    res += k
    
    //fmt.Printf("Res: %+v \n", res)
    //fmt.Printf("Na=%d Nb=%d Nc=%d \n", Na, Nb, Nc)
    //fmt.Printf("a=%d b=%d c=%d ab=%d ac=%d bc=%d \n", a, b, c, ab, ac, bc)
    
    var best int
    for i:=0; i<=ab; i++ {
        for j:=0; j<=bc; j++ {
            for k:=0; k<=ac; k++ {
                if (Na-i-k) >= 0 && (Nb-i-j)>=0 && (Nc-j-k)>=0 {
                    
                    happy := i+j+k
                    
                    happy += Min(Min(Na-i-k, Nb-i-j), Min(Nc-j-k, abc))
                    
                    //fmt.Printf("happy=%d \n", happy)
                    
                    if happy > best {
                        best = happy
                    } 
                }
            }
        }
    }
    res += best
    fmt.Println(res)
}