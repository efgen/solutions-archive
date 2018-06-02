program Zzz;
{$APPTYPE CONSOLE}
uses Math;
var x,y,z:array[1..5000] of real;
i,j,k,n,m:integer;
r,f,t,xx,yy,zz,d,d2,res:real;
begin
{ Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input); Rewrite(output);             }
  Read(n,m,r);
  for i:=1 to m do
  begin
    Read(f,t);
    f:=Pi/2-Pi*f/180;
    t:=t*Pi/180;
    x[i]:=R*Sin(f)*Cos(t);
    y[i]:=R*Sin(f)*Sin(t);
    z[i]:=R*Cos(f);
  end;
  d:=2*R;
  for j:=1 to n do
  begin
    Read(f,t);
    f:=Pi/2-Pi*f/180;
    t:=t*Pi/180;
    xx:=R*Sin(f)*Cos(t);
    yy:=R*Sin(f)*Sin(t);
    zz:=R*Cos(f);
    res:=d;
    for i:=1 to m do
    begin
      d2:=Sqrt(Sqr(x[i]-xx)+Sqr(y[i]-yy)+Sqr(z[i]-zz));
      if d2<res then res:=d2;
    end;
    res:=d*ArcSin(res/d);
    Writeln(res:0:2);
  end;
  //   Close(input); Close(output);
end.