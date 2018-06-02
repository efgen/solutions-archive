{$APPTYPE CONSOLE}
var p,q,eps:extended;
n:integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);      }
  Read(p,q); p:=p/100; q:=q/100;
  n:=1; eps:=10e-8;
  while Trunc(n*q-eps)-Trunc(n*p+eps)=0 do inc(n);
  Writeln(n);
//  Close(input);Close(output);
end.
