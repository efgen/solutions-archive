var n,i:integer;
xp,yp,xc,yc,xb,yb,r,d:extended;
procedure Show;
begin
  Writeln(d:2:2);
  halt;
end;

begin
  Readln(N,R);
  d:=2*Pi*R;
  Readln(xc,yc); xb:=xc; yb:=yc;
  if N=1 then Show;
  for i:=2 to n do
  begin
    xp:=xc; yp:=yc;
    Readln(xc,yc);
    d:=d+Sqrt((xc-xp)*(xc-xp)+(yc-yp)*(yc-yp));
  end;
  d:=d+Sqrt((xc-xb)*(xc-xb)+(yc-yb)*(yc-yb));
  Show;
end.