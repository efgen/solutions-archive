{$APPTYPE CONSOLE}
uses Math;
var a,b,r,res:extended;
i,j,n,bi,bj,t,x:integer;
procedure Check(x,y:integer);
begin
  r:=a*x+b*y-x*x-y*y;
  if r>res then
  begin
    res:=r;
    bi:=x;
    bj:=y;
  end;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  Read(a,b,n); x:=Floor(b/2);
  res:=0; bi:=0; bj:=0;
  for i:=0 to n do
  begin
    Check(i,0);
    if (x>=0) and (x<=n-i) then Check(i,x);
    if (x+1>=0) and (x+1<=n-i) then Check(i,x+1);
    Check(i,n-i);
  end;      
  Writeln(res:0:2);
  Writeln(bi,' ',bj);
 // Close(input);Close(output);
end.
