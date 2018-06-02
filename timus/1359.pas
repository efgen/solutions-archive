{$APPTYPE CONSOLE}
uses Math;
var a:array[0..50,0..50] of extended;
t,g,dt,d:extended;
x0,y0,x,y,h,w:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);             }
  Read(w,h);  g:=10;
  for x:=0 to w do
    for y:=0 to h do
      a[x,y]:=100000000;
  a[0,0]:=0;
  for y0:=0 to h do
    for x0:=0 to w do
      for y:=y0+1 to h do
      begin
        d:=(Sqrt(2*g*y)-Sqrt(2*g*y0))/(g*(y-y0));
        for x:=x0 to w do
        begin
          t:=a[x0,y0]+d*Sqrt(Sqr(x-x0)+Sqr(y-y0));
          if t<a[x,y] then a[x,y]:=t;
        end;
      end;
  Writeln(a[w,h]:0:4);
//  Close(input);Close(output);
end.
