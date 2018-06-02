package main
import "fmt"

func Score(x, y int) int {
    if x > y {
        return 1
    } else {
        return 0
    }
}

func main() {
    var a0, a1, a2 int
    var b0, b1, b2 int
    
    fmt.Scanf("%d %d %d", &a0, &a1, &a2)
    fmt.Scanf("%d %d %d", &b0, &b1, &b2)
    
    var r1, r2 int
    
    r1 = Score(a0, b0) + Score(a1, b1) + Score(a2, b2)
    r2 = Score(b0, a0) + Score(b1, a1) + Score(b2, a2)
    
    fmt.Printf("%d %d\n", r1, r2)
}