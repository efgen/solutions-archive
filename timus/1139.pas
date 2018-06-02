{$APPTYPE CONSOLE}
uses Math;
var res,n,m,i,j,k:integer;
var a:array[0..33000] of extended;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);}
  Read(n,m); dec(n); dec(m);
  for i:=0 to n do
    a[i]:=i*m/n;
  res:=0;
  for i:=1 to n do
    res:=res+Ceil(a[i])-Floor(a[i-1]);
  Writeln(res);
//  Close(input);Close(output);
end.
