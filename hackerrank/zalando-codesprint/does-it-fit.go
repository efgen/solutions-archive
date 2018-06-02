package main
import (
    "fmt"  
    "math"
)

func Check(W, H, w, h float64) bool {  
    if (w >= math.Sqrt(W*W+H*H)) {
        return false;
    }
    
    if (h > H) {
        return false;
    }
        
    d := math.Sqrt(w*w+h*h)        
    x := math.Sqrt(d*d-H*H)
    sina := x/d
    sinb := h/d
    alf := math.Asin(sina)
    bet := math.Asin(sinb)
    gam := math.Pi/2 - alf - bet
    y := h * math.Sin(gam)
    
    //fmt.Printf("d=%0.5f x=%0.5f alf=%0.5f bet=%0.5f gam=%0.5f y=%0.5f res=%0.5f\n\n", d, x, alf, bet, gam, y, 2*x+y);
    
    return W >= 2*y+x
}

func CheckFirst(W, H, w, h float64) bool {  
    if (w <= W && h <= H) {
        return true;
    }
    if (w > W && h > H) {
        return false;
    }
    return Check(W, H, w, h);   
    
}

func Solve(W, H, w, h float64) bool {  
    //return CheckFirst(W, H, w, h)
     
    return (CheckFirst(W, H, w, h) ||
       CheckFirst(W, H, h, w) ||
       CheckFirst(H, W, w, h) ||
       CheckFirst(H, W, h, w))
}

func main() {    
    var W, H, w, h, r float64 
    var n int
    var str string
    fmt.Scanf("%f %f", &W, &H)
    fmt.Scanf("%d", &n)
    for i:=0; i<n; i++ {
        fmt.Scanf("%s", &str)        
        
        if str == "C" {
            fmt.Scanf("%f", &r)
            if (2*r > math.Min(W, H)) {
                fmt.Println("NO"); 
            } else {
                fmt.Println("YES");
            }
        } else {
            fmt.Scanf("%f %f", &w, &h)
            if (Solve(W, H, w, h)) {
                fmt.Println("YES");
            } else {
                fmt.Println("NO");
            }            
        }
    }
    
}