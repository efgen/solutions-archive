program Z1348;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var
ax,ay,bx,by,cx,cy,L:integer;
r1,r2,r,a,b,c:extended;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } Read(ax,ay,bx,by,cx,cy,L);
  r1:=Sqrt(Sqr(ax-cx)+Sqr(ay-cy));
  r2:=Sqrt(Sqr(bx-cx)+Sqr(by-cy));
  if (ax<>bx) or (ay<>by) then
  begin
    if r1>r2 then
    begin
      r:=r1; r1:=r2; r2:=r;
    end;
    if ((cx-ax)*(bx-ax)+(cy-ay)*(by-ay)>=0) and ((cx-bx)*(ax-bx)+(cy-by)*(ay-by)>=0) then
    begin
      a:=by-ay;
      b:=ax-bx;
      c:=-a*ax-b*ay;
      r:=Abs(a*cx+b*cy+c)/Sqrt(a*a+b*b);
      if r<r1 then r1:=r;
    end;
  end;
  if r1>L then r1:=r1-L else r1:=0;
  if r2>L then r2:=r2-L else r2:=0;
  Writeln(r1:0:2);
  Writeln(r2:0:2);
//  Close(input); Close(output);
end.